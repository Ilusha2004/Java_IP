package cross_cutting.BuilderAriphmeticParser;

import cross_cutting.EnumTypes.Extensions;
import cross_cutting.Parsers.Parser;
import cross_cutting.Parsers.Writer;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        ParserFabric fabric = new ParserFabric("src/res/test.txt", "src/res/test2.xml");


        ParserAndWriterBuilder builder = new ParserAndWriterBuilder();

        fabric.Create(builder);
        Parser parser = builder.getParser();
        Writer writer = builder.getWriter();

            parser.parse();
            writer.write();

    }

}
