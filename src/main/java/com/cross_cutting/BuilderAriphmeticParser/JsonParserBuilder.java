package com.cross_cutting.BuilderAriphmeticParser;

public class JsonParserBuilder implements BuilderParserManager {
    private Parser parser;
    private String inPath;
    private String outPath;

    @Override
    public void setParser(Parser parser) {
        this.parser = parser;
    }

    @Override
    public void setInPath(String inPath) {
        this.inPath = inPath;
    }

    @Override
    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

}
