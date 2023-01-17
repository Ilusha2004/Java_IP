package com.cross_cutting.Parsers.XMLParser;

import com.cross_cutting.Arifmetic.AriphmeticParser;
import com.cross_cutting.Parsers.Parser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLParser extends Parser {
    private static ArrayList<Double> rezuList = new ArrayList<>();

    public XMLParser(String inPath) {
        super(inPath);
    }

    @Override
    public void parse() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        HEXParse par = new HEXParse();
        System.out.println(getInPath());
        parser.parse(new File(getInPath()), par);
    }

    private static class HEXParse extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("RawString")) {
                String str = attributes.getValue("str");
                AriphmeticParser tAriphmeticParser = new AriphmeticParser(str);
                rezuList.add(tAriphmeticParser.getResult());
            }
        }

    }

}