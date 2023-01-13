package cross_cutting.DecoratorFileManager;

import cross_cutting.EnumTypes.Actions;
import cross_cutting.EnumTypes.Extensions;

import java.io.File;
import java.nio.file.Files;

public class Main {
    static String path = "src/res/test.txt";
    public static void main(String[] args) throws Exception {

        File file = new File("src/res/test.txt");
        File file1 = new File("src/res/test.txt");

        Files.copy(file.toPath(), file1.toPath());

        DataDecorator dec = new FileArchivator(new FileEncrypt(new FileSource(path, Extensions.ZIP, Extensions.JSON, Actions.ARCHIVE_AND_ENCRYPT, null)));
        dec.writeData();

    }
}
