package com.cross_cutting.HelpfulThings;

import com.cross_cutting.EnumTypes.Extensions;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class FilePath {

    private static String name;
    private static String path;
    private static String extension;
    private static String firstExtension;
    private static String firstName;
    private static Extensions fileExtension;

    public FilePath(String path) {

        StringTokenizer tokenizer = new StringTokenizer(path, "/\\");
        ArrayList<String> temp = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            temp.add(tokenizer.nextToken());
        }

        String[] NameAndExtension = temp.get(temp.size() - 1).replace(".", " ").split(" ");

        this.path = path;
        this.name = NameAndExtension[0];
        this.extension = NameAndExtension[1];
        this.firstExtension = this.extension;


        if(extension.equals("txt")){
            this.fileExtension = Extensions.TXT;
        }
        else if(extension.equals("json")) {
            this.fileExtension = Extensions.JSON;
        }
        else if(extension.equals("xml")) {
            this.fileExtension = Extensions.XML;
        }

        System.out.println(fileExtension);

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFirstExtension() {
        return firstExtension;
    }

    public void setFirstExtension(String firstExtension) {
        this.firstExtension = firstExtension;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Extensions getFileExtension() {
        return fileExtension;
    }
}
