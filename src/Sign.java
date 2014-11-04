import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Sign {
	public static void main(String[] args) {
		Security.addProvider(new BouncyCastleProvider());
		Provider bc = Security.getProvider("BC");
		
		String messageFileName = Values.MESSAGE_FILENAME;
		
		byte[] data = null;
		try {
			Path path = Paths.get(Values.PRIVATE_KEY_FILENAME);
			data = Files.readAllBytes(path);
		} catch (IOException e) {
			System.out.println("Can't read private key " + Values.PRIVATE_KEY_FILENAME + " from disk");
			System.exit(-1);
		}
		
		PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(data);
		KeyFactory keyFactory = null;
		try {
			keyFactory = KeyFactory.getInstance(Values.ALGORITHM, bc);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Can't find key algorithm " + Values.ALGORITHM);
			System.exit(-1);
		}
		
		PrivateKey privateKey = null;
		Signature signer = null;
		try {
			privateKey = keyFactory.generatePrivate(privateKeySpec);
			signer = Signature.getInstance(Values.SIGN_ALGORITHM, bc);
			signer.initSign(privateKey);
		} catch (InvalidKeyException | InvalidKeySpecException e) {
			System.out.println("Input data from " + Values.PRIVATE_KEY_FILENAME + " is invalid");
			e.printStackTrace();
			System.exit(-1);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Can't find signature algorithm " + Values.SIGN_ALGORITHM);
			System.exit(-1);
		}
		
		byte[] digitalSignature = null;
		try {
			Path path = Paths.get(messageFileName);
			byte[] messageData = Files.readAllBytes(path);
			signer.update(messageData);
			digitalSignature = signer.sign();
		} catch (SignatureException e) {
			System.out.println("Can't sign the message");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Can't read message file " + messageFileName);
			e.printStackTrace();
			System.exit(-1);
		}
		
		File signatureFile = new File(Values.SIGNATURE_FILENAME);
		try {
			FileOutputStream signatureOutput = new FileOutputStream(signatureFile);
			signatureOutput.write(digitalSignature);
			signatureOutput.close();
		} catch (FileNotFoundException e) {
			System.out.println("Can't write to signature file " + signatureFile.getAbsolutePath());
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Can't write to signature file " + signatureFile.getAbsolutePath());
			e.printStackTrace();
			System.exit(-1);
		}
		
	}
	
	public Sign() {
		
	}
}
