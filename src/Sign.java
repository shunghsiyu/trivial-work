import java.io.File;
import java.io.FileOutputStream;
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

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Sign {
	/* ----- Main Method ----- */

	public static void main(String[] args) {
		Sign s = new Sign(Values.KEY_ALGORITHM, Values.SIGN_ALGORITHM);
		s.initialize(Values.PRIVATE_KEY_FILENAME);
		s.sign(Values.MESSAGE_FILENAME);
		s.writeSignatureTo(Values.SIGNATURE_FILENAME);
	}

	/* ----- Class Definition ----- */

	private String provider = Values.PROVIDER;
	private boolean initalized;
	private String keyAlgorithm;
	private String signAlgorithm;
	private PrivateKey privateKey;
	private Signature signer;
	byte[] digitalSignature;

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
		this.digitalSignature = null;
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
		KeyFactory keyFactory = Utils.getKeyFactoryInstance(keyAlgorithm, provider);
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
		Signature signature = Utils.getSignatureInstance(signAlgorithm, provider);
		try {
			signature.initSign(privateKey);
		} catch (InvalidKeyException e) {
			System.out.println("Input private key is invalid");
			System.exit(-1);
		}
		return signature;
	}

	/**
	 * Sign a file with the specified filename. Must call initialize() to to
	 * associate this instance before this method is called.
	 * 
	 * @param filename
	 *            the filename of the file that was to be signed
	 * @return the digital signature of the specified file
	 */
	public byte[] sign(String filename) {
		if (!initalized) {
			throw new IllegalStateException("Must initialize first!");
		}

		try {
			Path path = Paths.get(filename);
			byte[] messageData = Files.readAllBytes(path);
			signer.update(messageData);
			this.digitalSignature = signer.sign();
		} catch (SignatureException e) {
			System.out.println("Can't sign the message");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Can't read message file " + filename);
			e.printStackTrace();
			System.exit(-1);
		}

		return digitalSignature.clone();
	}

	/**
	 * Write the generated signature to the specified file. Need to call
	 * initialize() and sign() before calling this method.
	 * 
	 * @param filename
	 *            the filename of file to which the digital signature will be
	 *            written
	 */
	public void writeSignatureTo(String filename) {
		if (!initalized) {
			throw new IllegalStateException("Must initialize first!");
		} else if (digitalSignature == null) {
			throw new IllegalStateException(
					"The signature hasn't been generated yet!");
		}

		File signatureFile = new File(filename);
		try (FileOutputStream signatureOutput = new FileOutputStream(
				signatureFile)) {
			signatureOutput.write(digitalSignature);
		} catch (IOException e) {
			System.out.println("Can't write to signature file "
					+ signatureFile.getAbsolutePath());
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
