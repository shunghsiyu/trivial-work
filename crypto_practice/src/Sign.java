import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Sign {
	/* ----- Main Method ----- */

	public static void main(String[] args) {
		Sign s = new Sign(Values.KEY_ALGORITHM, Values.SIGN_ALGORITHM);
		s.initialize(Values.PRIVATE_KEY_FILENAME);
		s.sign(Values.MESSAGE_FILENAME);
		s.writeSignatureTo(Values.SIGNATURE_FILENAME);
		System.out.println("File signed");
	}

	/* ----- Class Definition ----- */

	private String provider = Values.PROVIDER;
	private boolean initalized;
	private String keyAlgorithm;
	private String signAlgorithm;
	private PrivateKey privateKey;
	private Signature signer;
	private Map<String, String> map;

	/**
	 * Constructor of Sign class.
	 * 
	 * @param keyAlgorithm
	 *            the algorithm used for the generation of the private key
	 * @param signAlgorithm
	 *            the algorithm that will be used to sign the message
	 */
	public Sign(String keyAlgorithm, String signAlgorithm) {
		if (Security.getProvider(provider) == null) {
			Security.addProvider(new BouncyCastleProvider());
		}
		this.initalized = false;
		this.keyAlgorithm = keyAlgorithm;
		this.signAlgorithm = signAlgorithm;
		this.map = new LinkedHashMap<>();
	}

	/**
	 * Initialize this Sign instance with a private key file in DER format.
	 * 
	 * @param privateKeyFilename
	 *            the filename of the private key file
	 */
	public void initialize(String privateKeyFilename) {
		privateKey = readPrivateKeyFrom(privateKeyFilename);
		signer = prepareAndGetSigner();
		map.clear();
		this.initalized = true;
	}

	/**
	 * Read in a private key from the specified file
	 * 
	 * @param filename
	 *            the filename of the private key file
	 * @return the private key that was read from the specified file
	 */
	private PrivateKey readPrivateKeyFrom(String filename) {
		PrivateKey key = null;
		KeyFactory keyFactory = Utils.getKeyFactoryInstance(keyAlgorithm,
				provider);
		try {
			Path path = Paths.get(filename);
			byte[] privateKeyData = Files.readAllBytes(path);
			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(
					privateKeyData);
			key = keyFactory.generatePrivate(privateKeySpec);
		} catch (InvalidKeySpecException e) {
			System.out.println("Input data from " + filename + " is invalid");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Can't read private key " + filename
					+ " from disk");
			System.exit(-1);
		}
		return key;
	}

	/**
	 * Get a Signature instance that uses the signing algorithm and provider
	 * that corresponds to those specified in the fields of this instance and
	 * initialize it with the private key associated with this instance.
	 * 
	 * @return a signature instance that can be used for signing
	 */
	private Signature prepareAndGetSigner() {
		Signature signature = Utils.getSignatureInstance(signAlgorithm,
				provider);
		try {
			signature.initSign(privateKey);
		} catch (InvalidKeyException e) {
			System.out.println("Input private key is invalid");
			System.exit(-1);
		}
		return signature;
	}

	/**
	 * Sign all the files that can be found under a specified file path. Must
	 * call initialize() to to associate this instance before this method is
	 * called.
	 * 
	 * @param filepath
	 *            the path of the file/directory that was to be signed
	 * @return the digital signature of the specified file
	 */
	public void sign(String filepath) {
		if (!initalized) {
			throw new IllegalStateException("Must initialize first!");
		}

		SignWalk walker = new SignWalk(filepath);
		walker.walk();
	}

	/**
	 * Utility class to walk the directory tree. Calculate signature for all
	 * file it encountered and add it to the map of this Sign instance.
	 *
	 */
	private class SignWalk extends Utils.FileWalker {
		/**
		 * Constructor of SignWalk class.
		 * 
		 * @param filepath
		 *            the start path for walking the directory tree
		 */
		public SignWalk(String filepath) {
			super(filepath);
		}

		@Override
		void work(String relativePath) {
			String realPath = relativePath.substring(1);
			File file = new File(realPath);
			Path fileToRead = Paths.get(file.getAbsolutePath());
			byte[] digitalSignature = null;
			try {
				byte[] messageData = Files.readAllBytes(fileToRead);
				signer.update(messageData);
				digitalSignature = signer.sign();
			} catch (SignatureException e) {
				System.out.println("Can't sign the message");
				e.printStackTrace();
				System.exit(-1);
			} catch (IOException e) {
				System.out.println("Can't read message file "
						+ file.getAbsolutePath());
				e.printStackTrace();
				System.exit(-1);
			}
			String signatureInHex = Utils.byteArrayToHex(digitalSignature);
			map.put(realPath, signatureInHex);
		}
	}

	/**
	 * Write the generated signature to the specified file. Need to call
	 * initialize() and sign() before calling this method.
	 * 
	 * @param filename
	 *            the filename of file to which all the digital signatures will
	 *            be written
	 */
	public void writeSignatureTo(String filename) {
		if (!initalized) {
			throw new IllegalStateException("Must initialize first!");
		} else if (map.isEmpty()) {
			throw new IllegalStateException(
					"The signature hasn't been generated yet!");
		}

		File signatureFile = new File(filename);
		try (FileWriter signatureOutput = new FileWriter(signatureFile, false)) {
			Iterator<Entry<String, String>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, String> entry = it.next();
				signatureOutput.write("\"");
				signatureOutput.write(entry.getKey());
				signatureOutput.write("\" ");
				signatureOutput.write(entry.getValue());
				signatureOutput.write("\n");
			}
		} catch (IOException e) {
			System.out.println("Can't write to signature file "
					+ signatureFile.getAbsolutePath());
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
