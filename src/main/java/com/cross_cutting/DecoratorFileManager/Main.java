package com.cross_cutting.DecoratorFileManager;

public class Main {
    static String path = "src/res/test.txt";
    public static void main(String[] args) throws Exception {
        DataDecorator dec = new FileEncrypt(new FileDecode(new FileSource(path)));
        dec.writeData("dskjahvbasvb");
        System.out.println(dec.readData());
    }
}
