package com.cross_cutting.DecoratorFileManager;

public class FileDeArchivator extends DataDecorator{

    public FileDeArchivator(DecoratorFileInterface dec) {
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
