package com.spring.websup.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateFileController {
    @GetMapping("/CreateFile")
    public String userList() {
        return "CreateFile";
    }

    @PostMapping("/CreateFile")
    public String deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                             @RequestParam(required = true, defaultValue = "" ) String action,
                             @RequestParam(required = true, defaultValue = "" ) String inExtension,
                             @RequestParam(required = true, defaultValue = "" ) String outExtension) {

        if (action.equals("archive")){
            System.out.println("hui");
            return "archive";
        } else if (action.equals("encrypted")) {
            return "encrypted";
        } else if (action.equals("archiveAndEncrypted")) {
            return "archiveAndEncrypted";
        } else if (action.equals("archiveAndEncrypted")){
            return "archiveAndEncrypted";
        }

        return "redirect:/admin";
    }

    @GetMapping("/CreateFile/gt/{userId}")
    public String getUser(@PathVariable Long userId) {
        return "OK";
    }
}
