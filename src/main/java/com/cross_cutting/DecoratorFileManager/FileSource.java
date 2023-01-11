package com.cross_cutting.DecoratorFileManager;

import com.cross_cutting.EnumTypes.Actions;
import com.cross_cutting.EnumTypes.Extensions;
import com.cross_cutting.HelpfulThings.FilePath;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileSource implements DecoratorFileInterface {

    private static FilePath path;
    private static Extensions inExtension;
    private static Extensions outExtension;
    private static Actions actions;

    public FileSource(String path, Extensions inExtension, Extensions outExtension, Actions actions) {
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

    public static Extensions getInExtension() {
        return inExtension;
    }

    public static Extensions getOutExtension() {
        return outExtension;
    }

    public static Actions getActions() {
        return actions;
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
