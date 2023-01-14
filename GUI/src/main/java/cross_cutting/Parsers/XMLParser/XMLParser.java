package cross_cutting.Parsers.XMLParser;

import cross_cutting.Arifmetic.AriphmeticParser;
import cross_cutting.BuilderAriphmeticParser.Parser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLParser extends Parser {

    private static ArrayList<String> rawAriphStrings = new ArrayList<>();
    private static ArrayList<Double> rezuList = new ArrayList<>();

    public XMLParser(String inPath, String outPath) {
        super(inPath, outPath);
    }

    @Override
    public void parse() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        HEXParse par = new HEXParse();
        parser.parse(new File(getInPath()), par);
    }

    @Override
    public void write() throws IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element element = document.createElementNS(null, "Results");

            document.appendChild(element);

            try {

                for (var id : rezuList) {
                    element.appendChild(getResult(document, id.toString()));
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transform = transformerFactory.newTransformer();

            transform.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);

            StreamResult result = new StreamResult(new File(getOutPath()));

            transform.transform(source, result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static class HEXParse extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("RawString")) {
                String str = attributes.getValue("str");
                AriphmeticParser tAriphmeticParser = new AriphmeticParser(str);
                rezuList.add(tAriphmeticParser.getResult());
                rawAriphStrings.add(str);
            }
        }

    }

    private static Node getResult(Document doc, String value) {
        Element node = doc.createElement("Rezult");
        node.appendChild(doc.createTextNode(value));
        return node;
    }

}