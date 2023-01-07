package com.cross_cutting.DecoratorFileManager;

public class Main {
    static String path = "src/res/test.txt";
    public static void main(String[] args) throws Exception {
        DataDecorator dec = new FileArchivator(new FileEncrypt(new FileSource("src/res/orderout.txt")));
        System.out.println(FileSource.getFilePath().getName());
        System.out.println(FileSource.getFilePath().getFirstExtension());
        System.out.println(FileSource.getFilePath().getExtension());
        System.out.println();
        dec.writeData();
        System.out.println(dec.readData());
    }
}
