package com.cross_cutting.BuilderAriphmeticParser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Parser {

    private static ArrayList<String> rawAriphStrings = new ArrayList<String>();
    private static ArrayList<Double> rezuList = new ArrayList<>();

    private String inPath;
    private String outPath;

    public Parser(String inPath, String outPath) {
        this.inPath = inPath;
        this.outPath = outPath;
    }

    public abstract void parse() throws ParserConfigurationException, SAXException, IOException;
    public abstract void write() throws IOException;

    public String getInPath() {
        return inPath;
    }

    public String getOutPath() {
        return outPath;
    }
}
