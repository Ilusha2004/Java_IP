package cross_cutting.Parsers.TXTParser;

import cross_cutting.Arifmetic.AriphmeticParser;
import cross_cutting.Parsers.Parser;
import cross_cutting.Parsers.SingletonResulList;

import javax.annotation.processing.FilerException;
import java.io.*;
import java.util.ArrayList;

public class TxtParser extends Parser {

    private ArrayList<Double> rezuList = new ArrayList<>();

    public TxtParser(String inPath) {
        super(inPath);
    }

    @Override
    public void parse() {
        try (BufferedReader buffer = new BufferedReader(new FileReader(getInPath()))) {

            while (buffer.ready()) {
                String temp = buffer.readLine().toString();
                AriphmeticParser parser = new AriphmeticParser(temp);
                rezuList.add(parser.getResult());
            }

            SingletonResulList.getInstance(rezuList);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}