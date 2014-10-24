
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Gen {
	public static final String ALGORITHM = "RSA";
	public static final String PUBLIC_KEY_FILENAME = "public";
	public static final String PRIVATE_KEY_FILENAME = "private";
	
    public static void main(String[] args) {
		Security.addProvider(new BouncyCastleProvider());
		Provider bc = Security.getProvider("BC");
		
		int keysize = 1024;
		KeyPairGenerator kg = null;
		try {
			kg = KeyPairGenerator.getInstance(ALGORITHM, bc);
			kg.initialize(keysize);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Can't find algorithm " + ALGORITHM);
			System.exit(-1);
		}
		
		KeyPair keyPair = kg.generateKeyPair();
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();

		try {
			FileOutputStream privateKeyOutput = new FileOutputStream(PRIVATE_KEY_FILENAME);
			FileOutputStream publicKeyOutput = new FileOutputStream(PUBLIC_KEY_FILENAME);
			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKey.getEncoded());
			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
			publicKeyOutput.write(publicKeySpec.getEncoded());
			privateKeyOutput.write(privateKeySpec.getEncoded());
			privateKeyOutput.close();
			publicKeyOutput.close();
		} catch (IOException e) {
			System.out.println("Can't write key to disk");
		}
			
	}
}
