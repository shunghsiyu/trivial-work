import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

import junit.framework.TestCase;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.juniper.jmp.security.JSRestClient2;

public class XMLGetter {

	private static final String HOSTURL =  "https://172.16.0.152:443";
	private static final String USER =  "super";
	private static final String PASSWORD = "juniper123";

	JSRestClient2 client;
	
	public void setUp() throws Exception {
		client = new JSRestClient2();
		client.login();
		//logger=Logger.getLogger(TestCase.class.getName());
	}
	
	public String getReplyFrom(String id) throws IOException {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
        String uri = "/api/space/device-management/devices/" + id + "/exec-rpc";
		HttpPost request = new HttpPost(uri);
        request.setHeader("Accept", "application/vnd.net.juniper.space.device-management.rpc+xml;version=1");
        request.setHeader( "Content-Type", "application/vnd.net.juniper.space.device-management.rpc+xml;version=1;charset=UTF-8");

		String body = 	
			"<netconf>" +
			"  <rpcCommands>" +
			"    <rpcCommand>" +
			"      <![CDATA[<get-interface-information />" +
			"]]>" +
			"    </rpcCommand>" +
			"  </rpcCommands>" +
			"</netconf>" +
			"";
		request.setEntity(new StringEntity(body));
		
		String reply = "";
		for (int i = 0; i < 1; i++) {
		    HttpResponse response = client.getClient().request(request);
		    HttpEntity entity = response.getEntity();
		    //System.out.println("Entity: ");
		    if (entity != null) {
                reply = convertStreamToString(entity.getContent());
                EntityUtils.consume(entity);
            }
		}
		return reply;
	}
	
	public void tearDown() throws Exception {
		client.logout();
	}	
	
	public static String getProperty(String key,String defaultValue) {
		Properties prop = new Properties();
		try {
			InputStream is = TestCase.class
					.getResourceAsStream("/junit.properties");
			if (is == null) {
				return defaultValue;
			}
			prop.load(is);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String property = prop.getProperty(key);
		return property!=null?property:defaultValue;
	}		

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
