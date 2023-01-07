package com.cross_cutting.DecoratorFileManager;

import com.cross_cutting.HelpfulThings.FilePath;

import java.io.*;

public class FileSource implements DecoratorFileInterface {

    private static FilePath path;

    public FileSource(String path) {
        this.path = new FilePath(path);
    }

    public static void setname(String name) {
        FileSource.path.setFirstName(name);
    }

    public static void setextension(String extension) {
        FileSource.path.setFirstExtension(extension);
    }

    public static FilePath getFilePath() {
        return path;
    }

    public static void setPath(FilePath path) {
        FileSource.path = path;
    }

    @Override
    public void writeData() {
        System.out.println(FileSource.getFilePath().getName());
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
