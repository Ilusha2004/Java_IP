package cross_cutting.DecoratorFileManager;

import cross_cutting.EnumTypes.Actions;
import cross_cutting.EnumTypes.Extensions;

import java.io.File;

public class Main {
    static String path = "src/res//test.txt";


    public static void main(String[] args) throws Exception {

        DataDecorator dec = new FileArchivator(new FileDeArchivator(new FileEncrypt(new FileDecode(new FileSource(path, Extensions.ZIP, Extensions.JSON, Actions.ARCHIVE_AND_ENCRYPT, null)))));
        dec.writeData();
//        CreateActionForFile createActionForFile = new CreateActionForFile(path, Extensions.ZIP, Extensions.JSON, Actions.ARCHIVE_AND_ENCRYPT);
//        createActionForFile.CreateAction().writeData();
    }
}
