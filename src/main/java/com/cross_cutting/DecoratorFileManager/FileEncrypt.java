package com.cross_cutting.DecoratorFileManager;

public class FileEncrypt extends DataDecorator {

    public FileEncrypt(DecoratorFileInterface dec) {
        super(dec);
    }

    @Override
    public void writeData(String data) {

    }

    @Override
    public String readData() {
        return null;
    }
}
