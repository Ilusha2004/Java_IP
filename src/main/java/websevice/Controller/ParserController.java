package websevice.Controller;

import com.cross_cutting.BuilderAriphmeticParser.ParserAndWriterBuilder;
import com.cross_cutting.BuilderAriphmeticParser.ParserFabric;
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
import java.util.List;

@RestController
@RequestMapping("/")
public class ParserController {

    @GetMapping("/parse")
    public ResponseEntity Create() {
        return new ResponseEntity("this is controller(parse) is not starting", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/parse/files")
    public List<File> getFiles() {
        return FileController.getFiles();
    }


    @GetMapping("/parse/parsing")
    public void Parsing(@RequestParam(required = true, defaultValue = "path") String path) throws ParserConfigurationException, IOException, SAXException {
        ParserFabric fabric = new ParserFabric(path, null);

        ParserAndWriterBuilder builder = new ParserAndWriterBuilder();

        fabric.Create(builder);
        Parser parser = builder.getParser();
        Writer writer = builder.getWriter();

        parser.parse();
        writer.write();
    }

    @PostMapping(value = "/parse", consumes = "application/json", produces = "application/json")
    public String CreateAction(@RequestParam(required = true, defaultValue = "path") String path,
                               @RequestParam(required = true, defaultValue = "inExtension") String inExtension) {



        return "redirect:/admin";
    }

    @GetMapping("/parse/write")
    public String SaveNewFile(@RequestParam(required = true, defaultValue = "path") String path) throws FileNotFoundException {

        try(FileInputStream inputStream = new FileInputStream(new File(path))){

            int i=-1;
            while((i=inputStream.read())!=-1){

                System.out.print((char)i);
            }
            return "Save succesfull";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return "Save error!";
    }

    @GetMapping("/CreateFile/gt/{userId}")
    public String getFile(@PathVariable Iterable<File> userId) {

        return "OK";
    }


}
