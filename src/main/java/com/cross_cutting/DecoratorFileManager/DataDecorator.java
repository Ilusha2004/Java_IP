package com.cross_cutting.DecoratorFileManager;

public class DataDecorator implements DecoratorFileInterface{

    private DecoratorFileInterface dec;

    public DataDecorator(DecoratorFileInterface dec) {
        this.dec = dec;
    }

    @Override
    public void writeData() throws Exception {
        dec.writeData();
    }

    @Override
    public String readData() {
        return dec.readData();
    }
}
