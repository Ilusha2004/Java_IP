package cross_cutting.DecoratorFileManager;

public interface DecoratorFileInterface {
    void writeData() throws Exception;

    String readData();
}
