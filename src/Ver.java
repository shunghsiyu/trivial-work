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

	/**
	 * Constructor of Ver class.
	 * 
	 * @param keyAlgorithm
	 *            the algorithm used for the generation of the public key
	 * @param signAlgorithm
	 *            the algorithm that will be used to sign the message
	 */
	public Ver(String keyAlgorithm, String signAlgorithm) {
		super();
		this.keyAlgorithm = keyAlgorithm;
		this.signAlgorithm = signAlgorithm;
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
	 * Verify a message file with its signature.
	 * 
	 * @param messageFilename
	 *            the filename of the message file
	 * @param signatureFilename
	 *            the filename of the file that stores the signature of the
	 *            message file
	 * @return
	 */
	public boolean verify(String messageFilename, String signatureFilename) {
		if (!initalized) {
			throw new IllegalStateException(
					"This Ver instance has not been initalized");
		}

		boolean valid = false;
		try {
			Path path = Paths.get(messageFilename);
			byte[] messageData = Files.readAllBytes(path);
			path = Paths.get(signatureFilename);
			byte[] digitalSignature = Files.readAllBytes(path);
			verifier.update(messageData);
			valid = verifier.verify(digitalSignature);
		} catch (SignatureException e) {
			System.out.println("Can't verify the message");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Can't read message file " + messageFilename);
			e.printStackTrace();
			System.exit(-1);
		}
		return valid;
	}
}
