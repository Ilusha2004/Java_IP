package websevice.Controller;

import com.cross_cutting.BuilderAriphmeticParser.ParserAndWriterBuilder;
import com.cross_cutting.BuilderAriphmeticParser.ParserFabric;
import com.cross_cutting.HelpfulThings.FilePath;
import com.cross_cutting.Parsers.Parser;
import com.cross_cutting.Parsers.Writer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("/")
public class ParserController {

    public static FilePath filePath;

    @GetMapping("/parse")
    public ResponseEntity Create() {
        return new ResponseEntity("this is controller(parse) is not starting", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/parse/files")
    public List<File> getFiles() {
        return FileController.getFiles();
    }

    static String tempPath;
    private static String extension;

    @GetMapping("/parse/parsing")
    public ResponseEntity<File> Parsing(@RequestParam(required = true, defaultValue = "path") String path,
                                        @RequestParam(required = true, defaultValue = "extension") String extension)
            throws ParserConfigurationException, IOException, SAXException {

        FilePath filePath = new FilePath(path);

        tempPath = "src/res/out " + filePath.getName() + "." + extension;
        this.extension = extension;
        filePath.setPath(tempPath);

        ParserFabric fabric = new ParserFabric(path, "src/res/out " + filePath.getName() + "." + extension);

        ParserAndWriterBuilder builder = new ParserAndWriterBuilder();

        fabric.Create(builder);

        Parser parser = builder.getParser();
        Writer writer = builder.getWriter();

        parser.parse();
        writer.write();

        File file = new File("src/res/out " + filePath.getName() + "." + extension);

        return new ResponseEntity<File>(file, HttpStatus.OK);
    }

    @GetMapping("/parse/writting")
    public ResponseEntity<File> Writing(@RequestParam(required = true, defaultValue = "path") String path) throws IOException {
        File outFile = new File(path);
        File inFile = new File(tempPath);
        Files.copy(inFile.toPath(), outFile.toPath());
        return new ResponseEntity<File>(outFile, HttpStatus.OK);
    }

    @PostMapping(value = "/parse", consumes = "application/json", produces = "application/json")
    public String CreateAction(@RequestParam(required = true, defaultValue = "path") String path,
                               @RequestParam(required = true, defaultValue = "inExtension") String inExtension) {



        return "redirect:/admin";
    }

    @GetMapping("/parse/write")
    public ResponseEntity SaveNewFile(@RequestParam(required = true, defaultValue = "path") String path) throws FileNotFoundException {

        try(FileInputStream inputStream = new FileInputStream(new File(path))){

            int i=-1;
            while((i=inputStream.read())!=-1){
                System.out.print((char)i);
            }

            return new ResponseEntity("Save successful", HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return new ResponseEntity("Save error!", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/CreateFile/gt/{userId}")
    public String getFile(@PathVariable Iterable<File> userId) {

        return "OK";
    }




}
