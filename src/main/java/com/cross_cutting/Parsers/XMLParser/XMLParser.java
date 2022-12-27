package com.cross_cutting.Parsers.XMLParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.cross_cutting.Parsers.AriphmeticParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLParser {

    private static ArrayList<String> rawAriphStrings = new ArrayList<String>();
    private static ArrayList<Integer> rezuList = new ArrayList<>();

    public void Parse(String filePath) throws ParserConfigurationException, SAXException, IOException{

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        HEXParse par = new HEXParse();
        parser.parse(new File(filePath), par);
        
    }

    private static class HEXParse extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if(qName.equals("RawString")){
                String str = attributes.getValue("str");
                AriphmeticParser tAriphmeticParser = new AriphmeticParser(str);
                rezuList.add(tAriphmeticParser.getResult());
                rawAriphStrings.add(str);
            }
        }

    }

    public void WriteXMLFile(String filePath) {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
    
        try{
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element element = document.createElementNS(null, "Results");

            document.appendChild(element);
            
            try {
                for(var id : rezuList) {
                    element.appendChild(getResult(document, id.toString()));           
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transform = transformerFactory.newTransformer(); 
            
            transform.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);

            StreamResult result = new StreamResult(new File(filePath));

            transform.transform(source, result);

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static Node getResult(Document doc, String value) {
        Element node = doc.createElement("Rezult");
        node.appendChild(doc.createTextNode(value));       
        return node;
    }
 
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        XMLParser parser = new XMLParser();
        parser.Parse("src/res/ariph.xml");
        parser.WriteXMLFile("src/res/rez.xml");
    }
    
}