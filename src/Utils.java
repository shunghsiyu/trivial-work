import java.io.File;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;

public class Utils {
	/**
	 * Helper class for walking directory tree and do operations on file
	 * encounter.
	 * 
	 * @author shunghsiyu
	 *
	 */
	static abstract class FileWalker {
		String filepath;

		public FileWalker(String filepath) {
			this.filepath = filepath;
		}

		public void walk() {
			walk(filepath, "");
		}

		private void walk(String filepath, String parent) {
			File start = new File(filepath);
			if (start.isDirectory()) {
				File[] files = start.listFiles();

				for (File f : files) {
					if (f.isDirectory()) {
						walk(f.getAbsolutePath(), parent + "/" + f.getName());
					} else {
						work(parent + "/" + start + "/" + f.getName());
					}
				}
			} else {
				work(parent + "/" + start);
			}
		}

		abstract void work(String relativePath);
	}

	/**
	 * Try to get a Signature instance of the specified signing algorithm from
	 * the specified provider. Will terminate the program when it encounters
	 * related exceptions.
	 * 
	 * @param signAlgorithm
	 *            the signing algorithm
	 * @param provider
	 *            the provider for the Signature instance
	 * @return
	 */
	public static Signature getSignatureInstance(String signAlgorithm,
			String provider) {
		Signature signature = null;
		try {
			signature = Signature.getInstance(signAlgorithm, provider);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Can't find signature algorithm "
					+ signAlgorithm);
			System.exit(-1);
		} catch (NoSuchProviderException e) {
			System.out.println("Can't find provider " + provider);
			System.exit(-1);
		}
		return signature;
	}

	/**
	 * Try to get a KeyFactory instance of the specified key algorithm from the
	 * specified provider. Will terminate the program when it encounters related
	 * exceptions.
	 * 
	 * @param keyAlgorithm
	 *            the algorithm used to generate the keys
	 * @param provider
	 *            the provider for the KeyFactory instance
	 * @return
	 */
	public static KeyFactory getKeyFactoryInstance(String keyAlgorithm,
			String provider) {
		KeyFactory keyFactory = null;
		try {
			keyFactory = KeyFactory.getInstance(keyAlgorithm, provider);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Can't find key algorithm " + keyAlgorithm);
			System.exit(-1);
		} catch (NoSuchProviderException e) {
			System.out.println("Can't find provider " + provider);
			System.exit(-1);
		}
		return keyFactory;
	}

	/**
	 * Convert a String representation of hex values into binary representation.
	 * 
	 * @param s
	 *            String representation of the hex value
	 * @return binary representation of the hex value
	 */
	public static byte[] hexToByteArray(String s) {
		byte[] bytes = new byte[s.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2),
					16);
		}
		return bytes;
	}

	/**
	 * Convert a byte array into its String representation in hex value.
	 * 
	 * @param a
	 *            the byte array to be converted
	 * @return String representation of the hex value
	 */
	public static String byteArrayToHex(byte[] a) {
		StringBuffer sb = new StringBuffer(a.length * 2);
		for (int i = 0; i < a.length; i++) {
			sb.append(Integer.toString((a[i] >>> 4) & 0xf, 16));
			sb.append(Integer.toString(a[i] & 0xf, 16));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// Test
		String a = "abcd";
		System.out.println("a: " + a);
		byte[] b = a.getBytes();
		System.out.println("b: " + b);
		String c = byteArrayToHex(b);
		System.out.println("c: " + c);
		byte[] d = hexToByteArray(c);
		System.out.println("d: " + d);
		String e = new String(d);
		System.out.println("e: " + e);
	}
}
