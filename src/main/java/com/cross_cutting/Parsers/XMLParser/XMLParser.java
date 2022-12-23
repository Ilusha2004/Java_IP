package com.laba_6a.XMLParser;

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
import com.laba_6a.car.Car;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLParser {

    private static ArrayList<Car> cars = new ArrayList<Car>();
    private static Hashtable<Car, String> Cars = new Hashtable<Car, String>();

    public void Parse(String filePath) throws ParserConfigurationException, SAXException, IOException{

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        HEXParse par = new HEXParse();
        parser.parse(new File(filePath), par);
        
    }

    private static class HEXParse extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if(qName.equals("car")){
                String brand = attributes.getValue("brand");
                String pos = attributes.getValue("position");
                String vel = attributes.getValue("velocity");

                cars.add(new Car(Double.valueOf(pos),
                                 Double.valueOf(vel),
                                 brand,
                       null));
            }
        }

    }

    public void WriteXMLFile(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
    

        try{
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element element = document.createElementNS("Nürburgring", "Track");

            document.appendChild(element);
            
            try {

                for(var id : cars) {
                    element.appendChild(getCar(document,
                                        id.getBrand().toString(),
                                        id.getRaInteger().toString(),
                                        Cars.get(id)));
                                 
                }

            } catch (Exception e) {
                System.out.println("Error");
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transform = transformerFactory.newTransformer(); 
            
            transform.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);

            StreamResult result = new StreamResult(new File("resourses/xlout.xml"));

            transform.transform(source, result);


        } catch(Exception e) {
            e.getStackTrace();
        }

    }

    private static Node getCar(Document doc, String brandCar, String timePass, String PassingCar) {
        Element sportCar = doc.createElement("SportCar");
 
        sportCar.setAttribute("BrandCar", brandCar);
 
        sportCar.appendChild(getCarElements(doc, sportCar, "TimePass", timePass));
        sportCar.appendChild(getCarElements(doc, sportCar, "PassingCar", PassingCar)); 
        
        return sportCar;
    }
 
    private static Node getCarElements(Document doc, Element element, String timePass, String value) {
        Element node = doc.createElement(timePass);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    public static ArrayList<Car> getCars() {
        return cars;
    }

    public static void setCars(ArrayList<Car> caar) {
        XMLParser.cars = new ArrayList<>(caar);
    }

    public static void setcars(Hashtable<Car, String> caar) {
        Cars = caar;
    }
    
}