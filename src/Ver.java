import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class Ver {
	public static final String KEY_ALGORITHM = Gen.ALGORITHM;
	public static final String SIGN_ALGORITHM = Sign.SIGN_ALGORITHM;
	public static final String PUBLIC_KEY_FILENAME = Gen.PUBLIC_KEY_FILENAME;
	public static final String SIGNATURE_FILENAME = Sign.SIGNATURE_FILENAME;
	
	public static void main(String[] args) {
		Security.addProvider(new BouncyCastleProvider());
		Provider bc = Security.getProvider("BC");
		
		byte[] data = null;
		try {
			Path path = Paths.get(PUBLIC_KEY_FILENAME);
			data = Files.readAllBytes(path);
		} catch (IOException e) {
			System.out.println("Can't read public key " + PUBLIC_KEY_FILENAME + " from disk");
			System.exit(-1);
		}
		
		X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(data);
		KeyFactory keyFactory = null;
		try {
			keyFactory = KeyFactory.getInstance(KEY_ALGORITHM, bc);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Can't find key algorithm " + KEY_ALGORITHM);
			System.exit(-1);
		}
		
		PublicKey publicKey = null;
		Signature signer = null;
		try {
			publicKey = keyFactory.generatePublic(publicKeySpec);
			signer = Signature.getInstance(SIGN_ALGORITHM, bc);
			signer.initVerify(publicKey);
		} catch (InvalidKeyException | InvalidKeySpecException e) {
			System.out.println("Input data from " + PUBLIC_KEY_FILENAME + " is invalid");
			e.printStackTrace();
			System.exit(-1);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Can't find signature algorithm " + SIGN_ALGORITHM);
			System.exit(-1);
		}
		
		byte[] messageData = null;
		byte[] digitalSignature = null;
		try {
			Path path = Paths.get(Sign.MESSAGE_FILENAME);
			messageData = Files.readAllBytes(path);
			path = Paths.get(Sign.SIGNATURE_FILENAME);
			digitalSignature = Files.readAllBytes(path);
			signer.update(messageData);
			boolean valid = signer.verify(digitalSignature);
			if(valid) {
				System.out.println("The signature of message file is valid");
			} else {
				System.out.println("Error: the signature of message file is INVALID");
			}
		} catch (SignatureException e) {
			System.out.println("Can't sign the message");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Can't read message file " + Sign.MESSAGE_FILENAME);
			e.printStackTrace();
			System.exit(-1);
		}
		
	}

}
