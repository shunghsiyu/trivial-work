import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Gen {
	public static final String ALGORITHM = "RSA";
	public static final String PUBLIC_KEY_FILENAME = "public";
	public static final String PRIVATE_KEY_FILENAME = "private";
	public static final int KEYSIZE = 1024;

	/* ----- Main Method ----- */

	public static void main(String[] args) {
		Gen gen = new Gen(ALGORITHM, KEYSIZE);
		gen.initialize();
		gen.writePublicKey(PUBLIC_KEY_FILENAME);
		gen.writePrivateKey(PRIVATE_KEY_FILENAME);
	}

	/* ----- Class Definition ----- */

	public static final String PROVIDER = "BC";
	private boolean initialized;
	private String algorithm;
	private int keysize;
	private PrivateKey privateKey;
	private PublicKey publicKey;
	private String provider;

	/**
	 * Constructor of Gen class.
	 * 
	 * @param algorithm
	 *            the algorithm used to generate the key pair
	 * @param keysize
	 *            the size of the key
	 */
	public Gen(String algorithm, int keysize) {
		this.initialized = false;
		this.algorithm = algorithm;
		this.keysize = keysize;
		this.provider = PROVIDER;
	}

	/**
	 * Generate the private/public key pair for this instance.
	 */
	public void initialize() {
		if (Security.getProvider(provider) == null) {
			Security.addProvider(new BouncyCastleProvider());
		}
		KeyPairGenerator kg = getKeyPairGenerator();
		KeyPair keyPair = kg.generateKeyPair();
		privateKey = keyPair.getPrivate();
		publicKey = keyPair.getPublic();
	}

	/**
	 * Get a KeyPairGenerator
	 * 
	 * @return a KeyPairGenerator instance using the specific provider and
	 *         algorithm
	 */
	private KeyPairGenerator getKeyPairGenerator() {
		KeyPairGenerator kg = null;
		try {
			kg = KeyPairGenerator.getInstance(algorithm, provider);
			kg.initialize(keysize);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Can't find algorithm " + algorithm);
			System.exit(-1);
		} catch (NoSuchProviderException e) {
			System.out.println("Can't find provider " + provider);
			System.exit(-1);
		}
		return kg;
	}

	/**
	 * Write the DER encoded private key to file.
	 * 
	 * @param filename
	 *            the name of the output private key file
	 */
	public void writePrivateKey(String filename) {
		// Initialize this Gen instance if it had not been initialized
		if (!initialized) {
			initialize();
		}
		PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(
				privateKey.getEncoded());
		writeKeySpecs(filename, privateKeySpec);
	}

	/**
	 * Write the DER encoded public key to file.
	 * 
	 * @param filename
	 *            the name of the output public key file
	 */
	public void writePublicKey(String filename) {
		// Initialize this Gen instance if it had not been initialized
		if (!initialized) {
			initialize();
		}
		X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(
				publicKey.getEncoded());
		writeKeySpecs(filename, publicKeySpec);
	}

	/**
	 * Write a KeySpec object to the disk
	 * 
	 * @param filename
	 *            the output filename of the KeySpec object
	 * @param keySpec
	 *            the KeySpec object to be written to disk
	 */
	private void writeKeySpecs(String filename, EncodedKeySpec keySpec) {
		try (FileOutputStream keyOutput = new FileOutputStream(filename)) {
			keyOutput.write(keySpec.getEncoded());
		} catch (IOException e) {
			System.out.println("Can't write to file " + filename);
			System.exit(-1);
		}
	}
}
