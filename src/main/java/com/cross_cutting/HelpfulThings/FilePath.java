package com.cross_cutting.HelpfulThings;

public class FilePath {

    private static String name;
    private static String encryptedPath;
    private static String path;
    private static String extension;

    public FilePath(String path) {
        this.path = path;

        String[] arr = path.split("/");
        String[] temp = arr[arr.length - 1].replace(".", " ").split(" ");

        this.name = temp[temp.length - 2];
        this.extension = temp[temp.length - 1];
        this.encryptedPath = path;

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

    public String getEncryptedPath() {
        return encryptedPath;
    }

    public void setEncryptedPath(String encryptedPath) {
        this.encryptedPath = encryptedPath;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
