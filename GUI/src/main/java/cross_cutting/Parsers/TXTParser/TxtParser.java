package cross_cutting.Parsers.TXTParser;

import cross_cutting.Arifmetic.AriphmeticParser;

import javax.annotation.processing.FilerException;
import java.io.*;
import java.util.ArrayList;

public class TxtParser {

    private String path;
    private String outPath;

    private static ArrayList<Integer> rezuList = new ArrayList<>();

    public TxtParser(String path, String outPath) {
        this.path = path;
        this.outPath = outPath;
    }

    public TxtParser(String path) {
        this.path = path;
    }

    public void ReadFile() {
        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {

            while (buffer.ready()) {
                String temp = buffer.readLine().toString();
                AriphmeticParser parser = new AriphmeticParser(temp);
                rezuList.add(parser.getResult());
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    public void WriteFile() throws IOException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(outPath));) {

            for (var id : rezuList) {
                buffer.write(id.toString() + "\n");
            }

        } catch (FilerException e) {
            System.out.println("Error");
            e.getStackTrace();
        }
    }

}