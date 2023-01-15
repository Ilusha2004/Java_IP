package cross_cutting.Parsers;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Parser {

    private static ArrayList<Double> rezuList = new ArrayList<>();

    private String inPath;

    public Parser(String inPath) {
        this.inPath = inPath;
    }

    public abstract void parse() throws ParserConfigurationException, SAXException, IOException;

    public String getInPath() {
        return inPath;
    }

    public static ArrayList<Double> getRezuList() {
        return rezuList;
    }

}
