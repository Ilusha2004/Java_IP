package cross_cutting.DecoratorFileManager;

import cross_cutting.EnumTypes.Actions;
import cross_cutting.EnumTypes.Extensions;
import cross_cutting.HelpfulThings.FilePath;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileSource implements DecoratorFileInterface {

    private static FilePath path;
    private static Extensions inExtension;
    private static Extensions outExtension;
    private static Actions actions;
    private static Extensions archiveExtensions;

    public FileSource(String path, Extensions inExtension, Extensions outExtension, Actions actions, Extensions archiveExtensions) {
        this.path              = new FilePath(path);
        this.inExtension       = inExtension;
        this.outExtension      = outExtension;
        this.actions           = actions;
        this.archiveExtensions = archiveExtensions;
    }

    public static void setName(String name) {
        FileSource.path.setName(name);
    }

    public static void setExtension(String extension) {
        FileSource.path.setExtension(extension);
    }

    public static FilePath getFilePath() {
        return path;
    }

    public static void setPath(FilePath path) {
        FileSource.path = path;
    }

    public static Extensions getInExtension() {
        return inExtension;
    }

    public static Extensions getOutExtension() {
        return outExtension;
    }

    public static Actions getActions() {
        return actions;
    }

    public static Extensions getArchiveExtensions() {
        return archiveExtensions;
    }

    public static void setArchiveExtensions(Extensions archiveExtensions) {
        FileSource.archiveExtensions = archiveExtensions;
    }

    @Override
    public void writeData() {
        System.out.println("Finish");
    }

    @Override
    public String readData() {
        char[] buffer = null;
        File file = new File(path.getPath());
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new String(buffer);
    }


}
