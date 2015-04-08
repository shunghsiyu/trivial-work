import java.security.Provider;
import java.security.Security;
import java.util.Iterator;
import java.util.Map.Entry;

import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class List {
	public static void main(String[] args) {
		Security.addProvider(new BouncyCastleProvider());
		
		Provider bc = Security.getProvider("BC");
		Iterator<Entry<Object, Object>> it = bc.entrySet().iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next().getKey());
		}
	}
}
