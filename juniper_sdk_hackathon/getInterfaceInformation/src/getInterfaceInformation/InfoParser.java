package getInterfaceInformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.methods.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class InfoParser {
	String id;
	
	public InfoParser(String id) {
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
		for(Element pif: pifs.toArray(pifsArray)) {
			if(pif.select("input-bps").size() == 0) {
				continue;
			}
			
			// Name of the interface
			String name = pif.select("name").first().text();
			System.out.println(name);
			
			// Input bps
			double inputbps = Double.parseDouble(pif.select("input-bps").first().text());
			System.out.print("input-bps: ");
			System.out.println(inputbps);
			
			// Output bps
			double outputbps = Double.parseDouble(pif.select("output-bps").first().text());
			System.out.print("output-bps: ");
			System.out.println(outputbps);
			
			System.out.println();
		}
	}
}
