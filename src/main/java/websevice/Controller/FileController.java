package websevice.Controller;

import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class FileController {

    private static List<File> files = new ArrayList<>();

    public FileController() {
        files.addAll(List.of(new File("sfdalj"), new File("dfskj")));
    }

    @GetMapping("/files")
    static List<File> getFiles() {
        return files;
    }

    @GetMapping("/file")
    Optional<File> getFileById(@RequestParam(required = true, defaultValue = "id") String id) {
        for(var file : files) {
            if (file.getName().equals(id)) {
                return Optional.of(file);
            }
        }
        return Optional.empty();
    }

    @PostMapping(value = "/files", consumes = "application/json", produces = "application/json")
    File postFile(@RequestBody String file) {
        files.add(new File(file));
        return new File(file);
    }

    @PutMapping("/files/{id}")
    File putFile(@PathVariable String id, @RequestBody String file) {
        int fileindex = -1;

        for(var f : files) {
            if(f.getName().equals(id)) {
                fileindex = files.indexOf(f);
                files.set(fileindex, new File(file));
            }
        }

        return (fileindex == -1) ? postFile(file) : new File(file);
    }

    @DeleteMapping("/files/{id}")
    void deleteFile(@PathVariable String id) {
        files.removeIf(c -> c.getName().equals(id));
    }

}
