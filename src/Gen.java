
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.KeyGenerator;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Gen {
	private static final String DIGITS = "0123456789abcdef";
	
    public static void main(String[] args) {
		Security.addProvider(new BouncyCastleProvider());
		Provider bc = Security.getProvider("BC");
		
		String algorithm = "RSA";
		int keysize = 1024;
		KeyPairGenerator kg = null;
		try {
			kg = KeyPairGenerator.getInstance(algorithm, bc);
			kg.initialize(keysize);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Can't find algorithm " + algorithm);
			System.exit(-1);
		}
		
		KeyPair keyPair = kg.generateKeyPair();
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();

		System.out.println(toHex(publicKey.getEncoded()));
		System.out.println(toHex(privateKey.getEncoded()));
	}
    
	public static String toHex(byte[] data) {
		return toHex(data, data.length);
	}
	
	public static String toHex(byte[] data, int length)
    {
        StringBuffer	buf = new StringBuffer();
        
        for (int i = 0; i != length; i++)
        {
            int	v = data[i] & 0xff;
            
            buf.append(DIGITS.charAt(v >> 4));
            buf.append(DIGITS.charAt(v & 0xf));
        }
        
        return buf.toString();
    }
}
