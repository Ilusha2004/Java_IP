package cross_cutting.BuilderAriphmeticParser;

import cross_cutting.Parsers.Parser;
import cross_cutting.Parsers.Writer;

public interface BuilderParserManager {

    void setParser(Parser parser);
    void setWriter(Writer writer);
    void setInPath(String inPath);
    void setOutPath(String outPath);

}
