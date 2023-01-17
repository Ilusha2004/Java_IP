package cross_cutting.BuilderAriphmeticParser;

import cross_cutting.EnumTypes.Extensions;
import cross_cutting.Parsers.Parser;
import cross_cutting.Parsers.Writer;
import junit.framework.Assert;
import org.junit.After;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.io.FileInputStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ParserFabricTest {

    private File inFile;
    private File outFile;
    private String inPath;
    private String outPath;
    private ParserFabric fabric;
    private Parser parser;
    private Writer writer;
    private ParserAndWriterBuilder builderParserManager;

    @BeforeAll
    public void setUp() {

        inPath = new String("src/test/java/cross_cutting/BuilderAriphmeticParser/text.txt");
        outPath = new String("src/test/java/cross_cutting/BuilderAriphmeticParser/out.txt");
        inFile = new File(inPath);
        outFile = new File(outPath);

        try {
            outFile.createNewFile();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        fabric = new ParserFabric(inFile.getPath(), outFile.getPath());

        builderParserManager = new ParserAndWriterBuilder();

        fabric.Create(builderParserManager);
        parser = builderParserManager.getParser();
        writer = builderParserManager.getWriter();

    }

    @Test
    public void testWriteData() throws Exception {

        try {
            parser.parse();
            writer.write();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        StringBuffer buffer = new StringBuffer();

        try(FileInputStream inputStream = new FileInputStream(outFile)){

            int i=-1;
            while((i=inputStream.read())!=-1){
                buffer.append((char)i);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(buffer.toString());

        Assert.assertEquals("3406571.954916108\n" +
                "-1.2341619054365861E20\n" +
                "-7.2384783242234E10\n" +
                "1.3371663655463972\n" +
                "-10.0\n" +
                "-7.2384783242234E10\n" +
                "-10.0\n" +
                "-1.2341619054365861E20\n" +
                "-10.0\n" +
                "-7.2384783242234E10\n", buffer.toString());
    }

    @Test
    public void TestInExtensions() {
        Assert.assertEquals(Extensions.TXT ,fabric.getInExtensions());
    }

    @Test
    public void TestOutExtension() {
        Assert.assertEquals(Extensions.TXT, fabric.getOutExtensions());
    }

    @After
    public void clear(){
        outFile.delete();
    }

}