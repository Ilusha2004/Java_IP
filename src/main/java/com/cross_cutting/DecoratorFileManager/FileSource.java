package com.cross_cutting.DecoratorFileManager;

import com.cross_cutting.EnumTypes.Extensions;
import com.cross_cutting.HelpfulThings.FilePath;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileSource implements DecoratorFileInterface {

    private static FilePath path;
    private static FilePath firstPath;
    private static Extensions archiveExtensions;

    public FileSource(String path, Extensions archiveExtensions) {
        this.path              = new FilePath(path);
        this.archiveExtensions = archiveExtensions;
        this.firstPath = new FilePath(path);
    }

    public static FilePath getFirstPath() {
        return firstPath;
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


    public static Extensions getArchiveExtensions() {
        return archiveExtensions;
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
