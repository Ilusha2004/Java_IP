package com.cross_cutting.DecoratorFileManager;

import com.cross_cutting.HelpfulThings.FilePath;

import java.io.*;

public class FileSource implements DecoratorFileInterface {

    private static FilePath path;

    public FileSource(String path) {
        this.path = new FilePath(path);
    }

    public static FilePath getFilePath() {
        return path;
    }

    public static void setPath(FilePath path) {
        FileSource.path = path;
    }

    @Override
    public void writeData(String data) {

        File file = new File(path.getPath());
        try (OutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
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
