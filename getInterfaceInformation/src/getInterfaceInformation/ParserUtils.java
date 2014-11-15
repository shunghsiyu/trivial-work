package getInterfaceInformation;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Scanner;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

public class ParserUtils {
	private static final String USER = "super";
	private static final String PASSWORD = "juniper123";
	private static final String PROTOCOL = "https";
	private static final String HOST = "172.16.0.152";
	private static final String PORT = "443";

	static class Client extends DefaultHttpClient {
	
		HttpHost host;
		private BasicHttpContext localcontext;
	
		public Client(String proto, String host, String port,
				ClientConnectionManager cm) {
			super(cm);
			this.host = new HttpHost(host, Integer.valueOf(port), proto);
		}
	
		public Client(String proto, String host, String port) {
			this.host = new HttpHost(host, Integer.valueOf(port), proto);
		}
	
		void login(String username, String password) {
			AuthScope authScope = new AuthScope(host.getHostName(),
					host.getPort());
			UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(
					username, password);
			getCredentialsProvider().setCredentials(authScope, credentials);
			// Create AuthCache instance
			AuthCache authCache = new BasicAuthCache();
			// Generate BASIC scheme object and add it to the local auth cache
			BasicScheme basicAuth = new BasicScheme();
			authCache.put(host, basicAuth);
			localcontext = new BasicHttpContext();
			localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);
		}
	
		HttpResponse request(HttpRequestBase request)
				throws ClientProtocolException, IOException {
			return execute(host, request, localcontext);
		}
	
	}

	static class TrustedConnectionManager extends SingleClientConnManager {
	
		public TrustedConnectionManager() throws KeyManagementException,
				NoSuchAlgorithmException {
			super(null, schemeRegistry());
		}
	
		static SchemeRegistry schemeRegistry() throws NoSuchAlgorithmException,
				KeyManagementException {
			SSLContext sslContext = SSLContext.getInstance("SSL");
	
			// set up a TrustManager that trusts everything
			sslContext.init(null, new TrustManager[] { new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					// System.out.println("getAcceptedIssuers =============");
					return null;
				}
	
				public void checkClientTrusted(X509Certificate[] certs,
						String authType) {
					// System.out.println("checkClientTrusted =============");
				}
	
				public void checkServerTrusted(X509Certificate[] certs,
						String authType) {
					// System.out.println("checkServerTrusted =============");
				}
			} }, new SecureRandom());
	
			SSLSocketFactory sf = new SSLSocketFactory(sslContext);
			sf.setHostnameVerifier(new X509HostnameVerifier() {
	
				public boolean verify(String hostname, SSLSession session) {
					return false;
				}
	
				public void verify(String arg0, String[] arg1, String[] arg2)
						throws SSLException {
	
				}
	
				public void verify(String arg0, X509Certificate arg1)
						throws SSLException {
	
				}
	
				public void verify(String arg0, SSLSocket arg1)
						throws IOException {
	
				}
			});
			SchemeRegistry schemeRegistry = new SchemeRegistry();
			schemeRegistry.register(new Scheme("https", 443, sf));
	
			// apache HttpClient version >4.2 should use
			return schemeRegistry;
		}
	
	}

	static String convertStreamToString(java.io.InputStream is) {
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}

	public static String getReplyFrom(String id) throws IOException,
			KeyManagementException, NoSuchAlgorithmException {
		Client client = new Client(ParserUtils.PROTOCOL, ParserUtils.HOST, ParserUtils.PORT,
				new TrustedConnectionManager());
		client.login(ParserUtils.USER, ParserUtils.PASSWORD);
	
		String uri = "/api/space/device-management/devices/" + id + "/exec-rpc";
		HttpPost request = new HttpPost(uri);
		request.setHeader("Accept",
				"application/vnd.net.juniper.space.device-management.rpc+xml;version=1");
		request.setHeader(
				"Content-Type",
				"application/vnd.net.juniper.space.device-management.rpc+xml;version=1;charset=UTF-8");
	
		String body = "<netconf>" + "  <rpcCommands>" + "    <rpcCommand>"
				+ "      <![CDATA[<get-interface-information/>" + "]]>"
				+ "    </rpcCommand>" + "  </rpcCommands>" + "</netconf>" + "";
		request.setEntity(new StringEntity(body));
	
		long time = System.currentTimeMillis();
		String reply = "";
		for (int i = 0; i < 1; i++) {
			HttpResponse response = client.request(request);// client.execute(host,
															// request,
															// localcontext);
			HttpEntity entity = response.getEntity();
			// System.out.println("Entity: ");
			if (entity != null) {
				reply = convertStreamToString(entity.getContent());
				EntityUtils.consume(entity);
			}
		}
		time = System.currentTimeMillis() - time;
		//System.out.println("Time: " + time);
		
		return reply;
	}

}
