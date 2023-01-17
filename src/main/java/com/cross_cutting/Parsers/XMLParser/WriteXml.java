package com.cross_cutting.Parsers.XMLParser;

import com.cross_cutting.Parsers.SingletonResulList;
import com.cross_cutting.Parsers.Writer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class WriteXml extends Writer {

    public WriteXml(String outPath) {
        super(outPath);
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

                for (var id : SingletonResulList.Data) {
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


    private static Node getResult(Document doc, String value) {
        Element node = doc.createElement("Rezult");
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
