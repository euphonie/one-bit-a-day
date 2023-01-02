import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LogParser {
    public static Document parseXmlFromString(String xmlString){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            InputStream inputStream = new    ByteArrayInputStream(xmlString.getBytes());
            org.w3c.dom.Document document = builder.parse(inputStream);
            return document;
        } catch (ParserConfigurationException e) {
            return null;
        } catch (SAXException e) {
            // TODO Auto-generated catch block
           return null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
           return null;
        }
    }
    
    public static Collection<Long> getTimestampsByDescription(String xml, String description) throws Exception {
        Collection<Long> timestamps = new ArrayList<Long>();
        Document events = LogParser.parseXmlFromString(xml);
        NodeList nl = events.getElementsByTagName("description");
        for (int i = 0; i < nl.getLength(); i++ ){
            Node text = nl.item(i).getChildNodes().item(0);
            if (!text.getNodeValue().toString().equals(description)){
                continue;
            }
            NamedNodeMap nnm = nl.item(i).getParentNode().getAttributes();
            String ts = nnm.getNamedItem("timestamp").toString();
            String onlyTime = ts.split("=")[1];
            timestamps.add(Long.parseLong(onlyTime.replace('"', ' ').trim()));
        }
        return timestamps;
    }
    
    public static void main(String[] args) throws Exception {
        String xml = 
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<log>\n" +
                "    <event timestamp=\"1614285589\">\n" +
                "        <description>Intrusion detected</description>\n" +
                "    </event>\n" +
                "    <event timestamp=\"1614286432\">\n" +
                "        <description>Intrusion ended</description>\n" +
                "    </event>\n" +
                "</log>";
        
        Collection<Long> timestamps = getTimestampsByDescription(xml, "Intrusion ended");
        for(long timestamp: timestamps)
            System.out.println(timestamp); 
    }
}