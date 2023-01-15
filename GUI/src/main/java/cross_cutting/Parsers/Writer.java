package cross_cutting.Parsers;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Writer {

    private static ArrayList<Double> rezuList = new ArrayList<>();
    private String outPath;

    public Writer(String outPath) {
        this.outPath = outPath;
    }

    public abstract void write() throws IOException;

    public String getOutPath() {
        return outPath;
    }
}
