package com.cross_cutting.BuilderAriphmeticParser;

import com.cross_cutting.Parsers.Parser;
import com.cross_cutting.Parsers.Writer;

public class ParserAndWriterBuilder implements BuilderParserManager {

    private Parser parser;
    private Writer writer;
    private String inPath;
    private String outPath;

    @Override
    public void setParser(Parser parser) {
        this.parser = parser;
    }

    @Override
    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void setInPath(String inPath) {
        this.inPath = inPath;
    }

    @Override
    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

    public Parser getParser() {
        return parser;
    }

    public Writer getWriter() {
        return writer;
    }

}
