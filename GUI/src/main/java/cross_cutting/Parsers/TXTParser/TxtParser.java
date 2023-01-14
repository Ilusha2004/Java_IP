package cross_cutting.Parsers.TXTParser;

import cross_cutting.Arifmetic.AriphmeticParser;
import cross_cutting.BuilderAriphmeticParser.Parser;

import javax.annotation.processing.FilerException;
import java.io.*;
import java.util.ArrayList;

public class TxtParser extends Parser {

    private static ArrayList<Double> rezuList = new ArrayList<>();

    public TxtParser(String inPath, String outPath) {
        super(inPath, outPath);
    }

    @Override
    public void parse() {
        try (BufferedReader buffer = new BufferedReader(new FileReader(getInPath()))) {

            while (buffer.ready()) {
                String temp = buffer.readLine().toString();
                AriphmeticParser parser = new AriphmeticParser(temp);
                rezuList.add(parser.getResult());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void write() throws IOException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(getOutPath()));) {

            for (var id : rezuList) {
                buffer.write(id.toString() + "\n");
            }

        } catch (FilerException e) {
            System.out.println(e.getMessage());
        }
    }

}