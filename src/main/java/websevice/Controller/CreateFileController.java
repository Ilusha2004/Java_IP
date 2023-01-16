package websevice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateFileController {
    @GetMapping("/CreateFile")
    public String Create() {
        return "CreateFile";
    }

    @PostMapping("/CreateFile")
    public String CreateAction(@RequestParam(required = true, defaultValue = "path") String path,
                               @RequestParam(required = true, defaultValue = "action") String action,
                               @RequestParam(required = true, defaultValue = "inExtension") String inExtension,
                               @RequestParam(required = true, defaultValue = "outExtension") String outExtension) {

        if (action.equals("archive")){
            System.out.println("hui");
            return "archive " + inExtension + " " + outExtension + " " + path;
        } else if (action.equals("encrypted")) {
            return "encrypted";
        } else if (action.equals("archiveAndEncrypted")) {
            return "archiveAndEncrypted";
        } else if (action.equals("archiveAndEncrypted")){
            return "archiveAndEncrypted";
        }

        return "redirect:/admin";
    }

    @GetMapping("/CreateFile/gt/write")
    public String getFile(@PathVariable Long userId) {

        return "OK";
    }
}
