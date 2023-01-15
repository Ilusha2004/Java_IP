package cross_cutting.Parsers.TXTParser;

import cross_cutting.Parsers.SingletonResulList;
import cross_cutting.Parsers.Writer;

import javax.annotation.processing.FilerException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTxt extends Writer {

    public WriteTxt(String outPath) {
        super(outPath);
    }

    @Override
    public void write() throws IOException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(getOutPath()));) {

            for (var id : SingletonResulList.Data) {
                buffer.write(id.toString() + "\n");
            }

        } catch (FilerException e) {
            System.out.println(e.getMessage());
        }
    }

}
