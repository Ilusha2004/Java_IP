package websevice.Controller;

import com.cross_cutting.DecoratorFileManager.CreateActionForFile;
import com.cross_cutting.EnumTypes.Actions;
import com.cross_cutting.EnumTypes.Extensions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

import static websevice.Controller.FileController.files;


@RestController
public class CreateFileController {
    @GetMapping("/CreateFile")
    public String Create() {
        return "CreateFile";
    }

    @GetMapping("/CreateFile/action")
    public ResponseEntity<String> CreateAction(@RequestParam(required = true, defaultValue = "path") String path,
                                      @RequestParam(required = true, defaultValue = "action") String action,
                                      @RequestParam(required = true, defaultValue = "extension") String extension) throws Exception {

        Extensions extensionsForFile = null;
        Actions actions = null;

        File file = new File(path);

        if(!file.exists()) {
            return new ResponseEntity<>("file doesn't exists", HttpStatus.BAD_REQUEST);
        }

        if(extension.equals("zip")) {
            extensionsForFile = Extensions.ZIP;
        } else if(extension.equals("jar")){
            extensionsForFile = Extensions.ZIP;
        } else if(extension.equals("rar")){
            extensionsForFile = Extensions.ZIP;
        }

        String pr = new String();

        if (action.equals("archive")){
            actions = Actions.ARCHIVE;
            pr = "archived_";
        } else if (action.equals("encrypted")) {
            actions = Actions.ENCRYPT;
            pr = "encrypted_";
        } else if (action.equals("archiveAndEncrypted")) {
            actions = Actions.ARCHIVE_AND_ENCRYPT;
            pr = "archived_encrypted_";
        } else if (action.equals("EncryptedAndArchived")){
            actions = Actions.ENCRYPT_AND_ARCHIVE;
            pr = "encrypted_archive_";
        }

        try {
            CreateActionForFile createActionForFile = new CreateActionForFile(path, actions, extensionsForFile);
            createActionForFile.CreateAction();
            createActionForFile.start();

        } catch(Exception ex) {
            throw new Exception();
        }

        return new ResponseEntity<String>("file " + action + " " + path + " was saved", HttpStatus.OK);
    }

    @PostMapping(value = "/CreateFile/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> SaveFile(@RequestBody String file) {
        files.add(new File(file));
        return new ResponseEntity<>(file, HttpStatus.OK);
    }

}
