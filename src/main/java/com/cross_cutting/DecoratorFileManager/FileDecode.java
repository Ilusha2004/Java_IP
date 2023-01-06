package com.cross_cutting.DecoratorFileManager;

public class FileDecode extends DataDecorator{

    public FileDecode(DecoratorFileInterface dec) {
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
