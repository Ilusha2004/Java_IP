package websevice.Controller;

import com.cross_cutting.DecoratorFileManager.CreateActionForFile;
import com.cross_cutting.EnumTypes.Actions;
import com.cross_cutting.EnumTypes.Extensions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static websevice.Controller.ParserController.tempPath;

@RestController
public class CreateFileController {
    @GetMapping("/CreateFile")
    public String Create() {
        return "CreateFile";
    }

    @PostMapping("/CreateFile")
    public String CreateAction(@RequestParam(required = true, defaultValue = "action") String action,
                               @RequestParam(required = true, defaultValue = "extension") String extension) throws Exception {

        Extensions extensionsForFile = null;
        Actions actions = null;

        if(extension.equals("zip")) {
            extensionsForFile = Extensions.ZIP;
        } else if(extension.equals("jar")){
            extensionsForFile = Extensions.ZIP;
        } else if(extension.equals("rar")){
            extensionsForFile = Extensions.ZIP;
        }

        if (action.equals("archive")){
            actions = Actions.ARCHIVE;
        } else if (action.equals("encrypted")) {
            actions = Actions.ENCRYPT;
        } else if (action.equals("archiveAndEncrypted")) {
            actions = Actions.ARCHIVE_AND_ENCRYPT;
        } else if (action.equals("archiveAndEncrypted")){
            actions = Actions.ENCRYPT_AND_ARCHIVE;
        }

        try {
            CreateActionForFile createActionForFile = new CreateActionForFile(tempPath, null, extensionsForFile, actions, extensionsForFile);
            createActionForFile.CreateAction();
            createActionForFile.start();

        } catch(Exception ex) {
            throw new Exception();
        }

        return "redirect:/admin";
    }

    @GetMapping("/CreateFile/afterAction/")
    public void BeforeAction(@RequestParam(required = true, defaultValue = "action") String action) {

    }

    @GetMapping("/CreateFile/gt/write")
    public String getFile(@PathVariable Long userId) {

        return "OK";
    }
}
