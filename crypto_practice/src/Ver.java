import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Ver {
	/* ----- Main Method ----- */

	public static void main(String[] args) {
		Ver ver = new Ver(Values.KEY_ALGORITHM, Values.SIGN_ALGORITHM);
		ver.initialize(Values.PUBLIC_KEY_FILENAME);
		boolean v = ver.verify(Values.MESSAGE_FILENAME,
				Values.SIGNATURE_FILENAME);
		System.out.print(Values.MESSAGE_FILENAME + " is ");
		System.out.println((v) ? "Valid" : "Invalid");
	}

	/* ----- Class Definition ----- */

	private String provider = Values.PROVIDER;
	private boolean initalized;
	private String keyAlgorithm;
	private String signAlgorithm;
	private PublicKey publicKey;
	private Signature verifier;
	private Map<String, String> map;

	/**
	 * Constructor of Ver class.
	 * 
	 * @param keyAlgorithm
	 *            the algorithm used for the generation of the public key
	 * @param signAlgorithm
	 *            the algorithm that was be used for signing
	 */
	public Ver(String keyAlgorithm, String signAlgorithm) {
		super();
		this.keyAlgorithm = keyAlgorithm;
		this.signAlgorithm = signAlgorithm;
		this.map = new HashMap<String, String>();
		this.initalized = false;
	}

	/**
	 * Initialize this Ver instance with a public key file in DER format.
	 * 
	 * @param publicKeyFilename
	 *            the filename of the public key file
	 */
	public void initialize(String publicKeyFilename) {
		if (Security.getProvider(provider) == null) {
			Security.addProvider(new BouncyCastleProvider());
		}
		publicKey = readPrivateKeyFrom(publicKeyFilename);
		verifier = prepareAndGetVerifier();
		map.clear();
		initalized = true;
	}

	/**
	 * Read in a public key from the specified file
	 * 
	 * @param filename
	 *            the filename of the public key file
	 * @return the public key that was read from the specified file
	 */
	private PublicKey readPrivateKeyFrom(String filename) {
		PublicKey key = null;
		KeyFactory keyFactory = Utils.getKeyFactoryInstance(keyAlgorithm,
				provider);
		try {
			Path path = Paths.get(filename);
			byte[] data = Files.readAllBytes(path);
			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(data);
			key = keyFactory.generatePublic(publicKeySpec);
		} catch (IOException e) {
			System.out.println("Can't read public key " + filename
					+ " from disk");
			System.exit(-1);
		} catch (InvalidKeySpecException e) {
			System.out.println("Input data from " + filename + " is invalid");
		}
		return key;
	}

	/**
	 * Get a Signature instance that uses the signing algorithm and provider
	 * that corresponds to those specified in the fields of this instance and
	 * initialize it with the public key associated with this instance.
	 * 
	 * @return a signature instance that can be used for verifying signature
	 */
	private Signature prepareAndGetVerifier() {
		Signature signature = Utils.getSignatureInstance(signAlgorithm,
				provider);
		try {
			signature.initVerify(publicKey);
		} catch (InvalidKeyException e) {
			System.out.println("Input public key is invalid");
			System.exit(-1);
		}
		return signature;
	}

	/**
	 * Verify a file path with its signature. If the path points to a folder
	 * then verify all the files inside it and its sub-directories.
	 * 
	 * @param verifyFilepath
	 *            the path of the file or folder to be verified
	 * @param signatureFilename
	 *            the filename of the file that stores the signature(s) of the
	 *            file(s)
	 * @return
	 */
	public boolean verify(String verifyFilepath, String signatureFilename) {
		if (!initalized) {
			throw new IllegalStateException(
					"This Ver instance has not been initalized");
		}

		readInSignatures(signatureFilename);

		VerWalker walker = new VerWalker(verifyFilepath);
		walker.walk();
		return walker.valid();
	}

	/**
	 * Read all the file signatures from the specified file into map.
	 * 
	 * @param signatureFilename
	 *            the name of the file that contains all the file signatures
	 */
	private void readInSignatures(String signatureFilename) {
		try (Scanner in = new Scanner(new File(signatureFilename))) {
			while (in.hasNext()) {
				String temp = in.next();
				String name = temp.substring(1, temp.length() - 1);
				String signatureInHex = in.next();
				map.put(name, signatureInHex);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Can't find file " + signatureFilename);
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Utility class to walk the directory tree. Verify all files it encountered
	 * with corresponding signature in the map of this Ver instance.
	 *
	 */
	private class VerWalker extends Utils.FileWalker {
		private boolean findInvalid;

		public VerWalker(String filepath) {
			super(filepath);
			findInvalid = false;
		}

		public boolean valid() {
			return (!findInvalid);
		}

		@Override
		void work(String relativePath) {
			String realPath = relativePath.substring(1);
			File file = new File(realPath);
			boolean valid = false;
			try {
				Path path = Paths.get(file.getAbsolutePath());
				byte[] messageData = Files.readAllBytes(path);
				String digitalSignatureInHex = map.get(realPath);
				if (digitalSignatureInHex == null) {
					findInvalid = true;
					System.out.println("\"" + file.getAbsolutePath()
							+ "\": NO CORRESPONDING SIGNATURE");
					return;
				}
				byte[] digitalSignature = Utils
						.hexToByteArray(digitalSignatureInHex);
				verifier.update(messageData);
				valid = verifier.verify(digitalSignature);
			} catch (SignatureException e) {
				System.out.println("Can't verify the message");
				e.printStackTrace();
				System.exit(-1);
			} catch (IOException e) {
				System.out.println("Can't read message file "
						+ file.getAbsolutePath());
				e.printStackTrace();
				System.exit(-1);
			}

			System.out.print("\"" + file.getAbsolutePath() + "\": ");
			if (!valid) {
				System.out.println("INVALID");
				findInvalid = true;
			} else {
				System.out.println("Valid");
			}
		}

	}
}
