package cross_cutting.DecoratorFileManager;

import cross_cutting.EnumTypes.Actions;
import cross_cutting.EnumTypes.Extensions;

public class Main {
    static String path = "src/res/test.txt";

    public static void main(String[] args) throws Exception {
        CreateActionForFile createActionForFile = new CreateActionForFile(path, Extensions.XML, Extensions.JSON, Actions.ARCHIVE);
        createActionForFile.CreateAction().writeData();
    }
}
