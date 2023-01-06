package com.cross_cutting.DecoratorFileManager;

public class FileArchivator extends DataDecorator {
    private String path;

    public FileArchivator(DecoratorFileInterface dec) {
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
