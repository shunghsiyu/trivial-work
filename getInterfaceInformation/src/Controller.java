
import org.apache.http.conn.ssl.SSLSocketFactory;

import java.util.ArrayList;
//import getInterfaceInformation;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;

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
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

class ParserUtils {

    private static final String USER = "super";
    private static final String PASSWORD = "juniper123";
    private static final String PROTOCOL = "https";
    private static final String HOST = "172.16.0.152";
    private static final String PORT = "443";

    @SuppressWarnings("deprecation")
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

    //SingleClientConnManager a = null;
    @SuppressWarnings("deprecation")
    static class TrustedConnectionManager extends SingleClientConnManager {

        @SuppressWarnings("deprecation")
        public TrustedConnectionManager() throws KeyManagementException,
                NoSuchAlgorithmException {
            //System.out.println("x");
            super(null, schemeRegistry());
            //System.out.println("x");
        }

        @SuppressWarnings("deprecation")
        static SchemeRegistry schemeRegistry() throws NoSuchAlgorithmException,
                KeyManagementException {
            SSLContext sslContext = SSLContext.getInstance("SSL");

            // set up a TrustManager that trusts everything
            sslContext.init(null, new TrustManager[]{new X509TrustManager() {
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
            }}, new SecureRandom());

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
        //System.out.println("a");
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

class LinkMetrics {
    //int MetricssType = 2;

    final int LinkNumber;
    public CopyOnWriteArrayList<Long> m;

    //int[] mE;
    //int[] mW;
    LinkMetrics(int n) {
        this.LinkNumber = n;
        m = new CopyOnWriteArrayList<Long>();
        //mW = new CopyOnWriteArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            m.add(0l);
            //mE.add(0);
        }
    }
}

class pair {

    public int in, out;

    pair(int in, int out) {
        this.in = in;
        this.out = out;
    }
}

class TOPOLOGY {

    public static final String[] ROUTERIDS = new String[]{"458771", "458773", "458779", "458783", "458787", "458791", "458795", "458801"};
    public static final String[] ROUTERNAMES = new String[]{"NY", "Chicago", "LA", "Dallas", "Miami", "Tampa", "Houston", "SF"};
    public static final int ROUTERNUMBER = 8;
    public static final int LINKNUMBER = 46;
    public static Link[] LINKS;// = new Link[LINKNUMBER];
    public static HashMap<String, HashMap<String, pair>> ROUTERS;// = new ArrayList<HashMap<String,pair>>(ROUTERNUMBER);
    public static final long BANDWIDTH = 1000000000l;

    static {
        LINKS = new Link[LINKNUMBER];
        for (int i = 0; i < LINKNUMBER; i++) {
            LINKS[i] = new Link(i, 1024);
        }

        ROUTERS = new HashMap<>(ROUTERNUMBER);

        HashMap<String, pair> interfacesChicago = new HashMap<>();
        HashMap<String, pair> interfacesDallas = new HashMap<>();
        HashMap<String, pair> interfacesSF = new HashMap<>();
        HashMap<String, pair> interfacesHouston = new HashMap<>();
        HashMap<String, pair> interfacesTempa = new HashMap<>();
        HashMap<String, pair> interfacesNY = new HashMap<>();
        HashMap<String, pair> interfacesMiami = new HashMap<>();
        HashMap<String, pair> interfacesLA = new HashMap<String, pair>();

        interfacesChicago.put("ge-1/0/1", new pair(23, 0));
        interfacesChicago.put("ge-1/0/2", new pair(24, 1));
        interfacesChicago.put("ge-1/0/3", new pair(25, 2));
        interfacesChicago.put("ge-1/0/4", new pair(26, 3));
        interfacesChicago.put("ge-1/0/5", new pair(17, 40));
        interfacesChicago.put("ge-1/0/6", new pair(18, 41));
        interfacesChicago.put("ge-1/0/7", new pair(19, 42));
        
        
        interfacesSF.put("xe-0/0/0", new pair(15, 38));
        interfacesSF.put("ge-1/0/0", new pair(30, 7));
        interfacesSF.put("ge-1/0/1", new pair(27, 4));
        interfacesSF.put("ge-1/0/3", new pair(0, 23));
        
        
        interfacesDallas.put("ge-0/1/0", new pair(4, 27));
        interfacesDallas.put("ge-0/1/1", new pair(31, 8));
        interfacesDallas.put("ge-0/1/2", new pair(32, 9));
        interfacesDallas.put("ge-0/1/3", new pair(28, 5));
        interfacesDallas.put("ge-1/3/0", new pair(1, 24));
        
        
        interfacesLA.put("ge-0/1/0", new pair(7, 30));
        interfacesLA.put("ge-0/1/1", new pair(8, 31));
        interfacesLA.put("ge-0/1/2", new pair(36, 13));
        interfacesLA.put("ge-0/1/3", new pair(43, 20));
        
        
        interfacesNY.put("ge-1/0/3", new pair(6, 29));
        interfacesNY.put("ge-1/0/5", new pair(3, 26));
        interfacesNY.put("ge-1/0/7", new pair(35, 12));
        interfacesNY.put("ge-1/0/8", new pair(39, 16));
        interfacesNY.put("xe-0/0/0", new pair(43, 20));
        
        
        interfacesMiami.put("ge-0/1/0", new pair(33, 10));
        interfacesMiami.put("ge-0/1/1", new pair(34, 11));
        interfacesMiami.put("ge-0/1/2", new pair(29, 6));
        interfacesMiami.put("ge-0/1/3", new pair(5, 28));
        interfacesMiami.put("ge-1/3/0", new pair(2, 25));
        
        
        interfacesTempa.put("ge-1/0/0", new pair(14, 37));
        interfacesTempa.put("ge-1/0/1", new pair(11, 34));
        interfacesTempa.put("ge-1/0/2", new pair(12, 35));
        interfacesTempa.put("ge-1/0/3", new pair(45, 22));
        
        
        interfacesHouston.put("ge-0/1/0", new pair(13, 36));
        interfacesHouston.put("ge-0/1/1", new pair(9, 32));
        interfacesHouston.put("ge-0/1/2", new pair(10, 33));
        interfacesHouston.put("ge-0/1/3", new pair(37, 14));
        interfacesHouston.put("ge-1/3/0", new pair(44, 21));
        

        //public static final String[] routerIDs = new String[]{"458771", "458773", "458779", "458783", "458787", "458791", "458795", "458801"};
        //public static final String[] routerNames = new String[]{"NY", "Chicago", "LA", "Dallas", "Miami", "Tampa", "Houston", "SF"};
        ROUTERS.put("458771", interfacesNY);
        ROUTERS.put("458773", interfacesChicago);
        ROUTERS.put("458779", interfacesLA);
        ROUTERS.put("458783", interfacesDallas);
        ROUTERS.put("458787", interfacesMiami);
        ROUTERS.put("458791", interfacesTempa);
        ROUTERS.put("458795", interfacesHouston);
        ROUTERS.put("458801", interfacesSF);
    }
    //private int ROUTENUMBER;

}

class ISPS {

    static final int ISPNUMBER = 4;
    static ArrayList<LSP> LSPS = new ArrayList<LSP>(ISPNUMBER);

//    static {
//        LinkedList<Link> temp = new LinkedList<Link>();
//
//        temp.add(TOPOLOGY.LINKS[4]);
//        temp.add(TOPOLOGY.LINKS[5]);
//        temp.add(TOPOLOGY.LINKS[6]);
//
//        LSPS.add(new LSP(0, 3, temp));
//
//        temp.clear();
//        temp.add(TOPOLOGY.LINKS[0]);
//        temp.add(TOPOLOGY.LINKS[3]);
//        //temp.add(TOPOLOGY.LINKS[6]);
//
//        LSPS.add(new LSP(1, 2, temp));
//
//        temp.clear();
//        temp.add(TOPOLOGY.LINKS[7]);
//        temp.add(TOPOLOGY.LINKS[13]);
//        temp.add(TOPOLOGY.LINKS[14]);
//        temp.add(TOPOLOGY.LINKS[35]);
//
//        LSPS.add(new LSP(2, 4, temp));
//
//        temp.clear();
//        temp.add(TOPOLOGY.LINKS[4]);
//        temp.add(TOPOLOGY.LINKS[24]);
//        temp.add(TOPOLOGY.LINKS[2]);
//        temp.add(TOPOLOGY.LINKS[11]);
//        temp.add(TOPOLOGY.LINKS[35]);
//        //temp.add(TOPOLOGY.LINKS[3]);
//
//        LSPS.add(new LSP(3, 5, temp));
//
//    }//static

}

class Link {

    int index;
    int bandwidth;

    Link(int index, int bandwidth) {
        this.index = index;
        this.bandwidth = bandwidth;
    }
}

class LSP {

    int index;
    int hops;
    LinkedList<Link> path;

    LSP(int index, int hops, LinkedList<Link> path) {
        this.index = index;
        this.hops = hops;
        this.path = path;
    }
}

class Monitor implements Runnable {

    class InfoParser {

        String id;

        public InfoParser(String id) {
            //System.out.println("instanlized parser with id: " + id);
            this.id = id;
        }

        public void parseAndPrint() throws KeyManagementException, NoSuchAlgorithmException, IOException {

            Document reply = Jsoup.parse(ParserUtils.getReplyFrom(id), "", Parser.xmlParser());

            Element replyMsgData = reply.select("replyMsgData").first();
            if (replyMsgData == null) {
                throw new IOException("Cann't retrieve configuration information from " + id);
            }

            Document information = Jsoup.parse(replyMsgData.text(), "", Parser.xmlParser());
            Elements pifs = information.select("physical-interface");
            Element[] pifsArray = new Element[pifs.size()];

            for (Element pif : pifs.toArray(pifsArray)) {
                if (pif.select("input-bps").size() == 0) {
                    continue;
                }

            // Name of the interface
                String name = pif.select("name").first().text();
                if (!(interfaces.containsKey(name))) {
                    //System.out.println("skip useless interface: "+ name+ " on Router "+id);
                    continue;
                    
                }
                pair bpspair = interfaces.get(name);

                double inputbps =  Double.parseDouble(pif.select("input-bps").first().text());
                double outputbps = Double.parseDouble(pif.select("output-bps").first().text());
                
                lm.m.set(bpspair.in, (long)inputbps);// .update (bpspair.in) = inputbps;
                lm.m.set(bpspair.out,(long)outputbps);
                
                //System.out.println("Setting link on router: "+id+"/"+RouterRealName+" | "+name +" with input: "+bpspair.in+" / ouput: "+bpspair.out);

                //System.out.println(name);

                //System.out.print("input-bps: ");
                //System.out.println(inputbps);
                // Output bps         
                //System.out.print("output-bps: ");
                //System.out.println(outputbps);

                //System.out.println();
            }

        }
    }

    InfoParser IParser;
    String RouterName;
    String RouterRealName;
    LinkMetrics lm;
    int index;
    HashMap<String, pair> interfaces;

    Monitor(int index, String name, String rname, LinkMetrics lm) {
        IParser = new InfoParser(name);
        this.index = index;
        this.RouterName = name;
        this.RouterRealName = rname;
        this.lm = lm;
        interfaces = TOPOLOGY.ROUTERS.get(name);
    }

    public void getLinkStat() {

        try {
            IParser.parseAndPrint();
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

		//TBD
        //
        //
        //lm.mW.set(index, 2);		
        //
        //
        //System.out.println("fetching " + RouterName);
        //		

    }

    ;
	@Override
    public void run() {
        while (true) {
            getLinkStat();
            Thread.yield();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}

class Engine implements Runnable {
    //private static final int L = 4;

    LinkMetrics lm;

    Engine(LinkMetrics lm) {

        this.lm = lm;
        //System.out.println(lsps);
        //System.out.println("Engine's on.");
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		//System.out.println("Engine start running.");

            //TBD
            //
            long l1, l2, l3, l4; //overloads
            l1 = Math.max(Math.max(lm.m.get(4), lm.m.get(5)), lm.m.get(6));
            l2 = Math.max(lm.m.get(23), lm.m.get(3));
            l3 = Math.max(Math.max(lm.m.get(7), lm.m.get(13)), Math.max(lm.m.get(14), lm.m.get(35)));
            l4 = Math.max(lm.m.get(4), Math.max(Math.max(lm.m.get(24), lm.m.get(2)), Math.max(lm.m.get(11), lm.m.get(35))));

            long l = Math.max(Math.max(TOPOLOGY.BANDWIDTH - l1, TOPOLOGY.BANDWIDTH - l2), Math.max(TOPOLOGY.BANDWIDTH - l3, TOPOLOGY.BANDWIDTH - l4));
            l = TOPOLOGY.BANDWIDTH - l;
            if (l == l2) {
                System.out.println("choose LSP 2");

            } else if (l == l1) {
                System.out.println("choose LSP 1");

            } else if (l == l3) {
                System.out.println("choose LSP 3");

            } else if (l == l4) {
                System.out.println("choose LSP 4");

            } else {
                System.out.println("opps");
            }
            Thread.yield();
        }

        //
        //
        //
        //
        //
        // TODO Auto-generated method stub
    }

}

class MonitoringThread extends Thread {

    MonitoringThread(Runnable r) {
        super(r);
    }
}

class MainThread extends Thread {

    MainThread(Runnable r) {
        super(r);
    }

}

class WriteList implements Runnable {
	LinkMetrics lm;
	
	public WriteList(LinkMetrics lm) {
		this.lm = lm;
	}
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			doWork();
			Thread.yield();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
	private void doWork() {
		StringBuffer sb = new StringBuffer();
		String start = 	"{" +
						"	\"linkMetrics\": [";
		sb.append(start);
		for(int i = 0; i < lm.m.size(); i++) {
			sb.append(lm.m.get(i));
			sb.append(", ");
		}
		sb.delete(sb.length()-2, sb.length());
		
		String end =  "]"
					+ "}";
		sb.append(end);
		
		try {
			FileWriter fw = new FileWriter("/Users/shunghsiyu/git/jsdkhackathon/network.json");
			fw.write(sb.toString());
			fw.close();
			System.out.println("JSON Written!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public class Controller {

   // private static final String[] ROUTERNAMES = {"458771", "458773", "458779", "458783", "458787", "458791", "458795", "458801"};
    //private static final int   = 7;
    //private static final int M = 15;
    //public ArrayList<Integer> l1 = new ArrayList<Integer>(M);
    //public ArrayList<Integer> l2 = new ArrayList<Integer>(M);
    //ArrayList<Integer> m1 = new ArrayList<Integer>(15);
    //ArrayList<Integer> m2 = new ArrayList<Integer>(15);

    public static void main(String[] args) {
        LinkMetrics matrix = new LinkMetrics(46);

        ArrayList<Monitor> monitors = new ArrayList<Monitor>(TOPOLOGY.ROUTERNUMBER);
        ArrayList<Thread> threads = new ArrayList<Thread>(TOPOLOGY.ROUTERNUMBER);
        for (int i = 0; i < TOPOLOGY.ROUTERNUMBER; i++) {
            monitors.add(new Monitor(i, TOPOLOGY.ROUTERIDS[i] ,TOPOLOGY.ROUTERNAMES[i], matrix));
        }
        for (int i = 0; i < TOPOLOGY.ROUTERNUMBER; i++) {
            threads.add(new MonitoringThread(monitors.get(i)));
        }
        for (int i = 0; i < TOPOLOGY.ROUTERNUMBER; i++) {
            threads.get(i).start();
        }
        Thread mainThread = new Thread(new Engine(matrix));
        mainThread.start();
        new Thread(new WriteList(matrix)).start();
		//Montors m1 = new Monitors()
        // TODO Auto-generated method stub
    }

}
