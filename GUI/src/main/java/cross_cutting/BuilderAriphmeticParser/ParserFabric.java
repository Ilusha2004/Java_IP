package cross_cutting.BuilderAriphmeticParser;

import cross_cutting.EnumTypes.Extensions;
import cross_cutting.Parsers.JsonParser.ParserJson;
import cross_cutting.Parsers.TXTParser.TxtParser;
import cross_cutting.Parsers.XMLParser.XMLParser;

public class ParserFabric {

    public void ConstructJsonParser(BuilderParserManager builderParserManager, String inPath, String outPath) {
        builderParserManager.setInPath(inPath);
        builderParserManager.setOutPath(outPath);
        builderParserManager.setParser(new ParserJson(inPath, outPath));
    }

    public void ConstructXMLParser(BuilderParserManager builderParserManager, String inPath, String outPath) {
        builderParserManager.setInPath(inPath);
        builderParserManager.setOutPath(outPath);
        builderParserManager.setParser(new XMLParser(inPath, outPath));
    }

    public void ConstructTxtParser(BuilderParserManager builderParserManager, String inPath, String outPath) {
        builderParserManager.setInPath(inPath);
        builderParserManager.setOutPath(outPath);
        builderParserManager.setParser(new TxtParser(inPath, outPath));
    }

    public void CreateConstructor(Extensions extensions) {

        if(extensions.equals(Extensions.TEXT)) {

        }
        else if (extensions.equals(Extensions.JSON)) {

        }
        else if (extensions.equals(Extensions.XML)) {

        }

    }
}
