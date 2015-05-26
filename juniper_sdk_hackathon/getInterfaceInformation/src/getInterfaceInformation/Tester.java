package getInterfaceInformation;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class Tester {
	public static final String[] routerIDs = new String[]{"458771", "458773", "458779", "458783", "458787", "458791", "458795", "458801"};
	public static final String[] routerNames = new String[]{"NY", "Chicago", "LA", "Dallas", "Miami", "Tampa", "Houston", "SF"};
	
	public static void main(String[] args) {
		try {
			for(int i = 0; i < routerIDs.length; i++) {
				System.out.println("From router id: " + routerIDs[i] + " at " + routerNames[i]);
				new InfoParser(routerIDs[i]).parseAndPrint();
			}
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
