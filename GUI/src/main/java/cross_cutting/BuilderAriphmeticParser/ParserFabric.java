package cross_cutting.BuilderAriphmeticParser;

import cross_cutting.EnumTypes.Extensions;
import cross_cutting.HelpfulThings.FilePath;
import cross_cutting.Parsers.JsonParser.ParserJson;
import cross_cutting.Parsers.JsonParser.WriteJson;
import cross_cutting.Parsers.TXTParser.TxtParser;
import cross_cutting.Parsers.TXTParser.WriteTxt;
import cross_cutting.Parsers.XMLParser.WriteXml;
import cross_cutting.Parsers.XMLParser.XMLParser;

public class ParserFabric {

    private String inPath;
    private String outPath;
    private Extensions inExtensions;
    private Extensions outExtensions;

    public ParserFabric(String inPath, String outPath) {

        FilePath filePath = new FilePath(inPath);
        this.inExtensions = filePath.getFileExtension();
        FilePath filePath1 = new FilePath(outPath);
        this.inPath = inPath;
        this.outPath = outPath;
        this.outExtensions = filePath1.getFileExtension();

    }

    public void Create(BuilderParserManager builderParserManager) {

        if(inExtensions.equals(Extensions.TXT)){
            builderParserManager.setParser(new TxtParser(inPath));
        }
        else if(inExtensions.equals(Extensions.XML)) {
            builderParserManager.setParser(new XMLParser(inPath));
        }
        else if(inExtensions.equals(Extensions.JSON)) {
            builderParserManager.setParser(new ParserJson(inPath));
        }
        if(outExtensions.equals(Extensions.TXT)){
            builderParserManager.setWriter(new WriteTxt(outPath));
        }
        else if(outExtensions.equals(Extensions.XML)) {
            builderParserManager.setWriter(new WriteXml(outPath));
        }
        else if(outExtensions.equals(Extensions.JSON)) {
            builderParserManager.setWriter(new WriteJson(outPath));
        }

    }

}
