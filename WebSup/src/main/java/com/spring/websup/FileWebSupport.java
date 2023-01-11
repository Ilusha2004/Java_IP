package com.spring.websup;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("FileManage/")
public class FileWebSupport {

    @RequestMapping("/{InExtension}")
    public String ChooseInExtension(@PathVariable String InExtension) {
        return "dsahg";
    }

    @PostMapping("/{FILE_PATH}")
    public String ChooseFile(@PathVariable String FILE_PATH) {
        File file = new File(FILE_PATH);

        if(file.exists()) {
            return String.format("File is %s!", file.getName());
        }

        return "Error";
    }

    @PostMapping("/{functionality}")
    public String ChooseFunctions(@PathVariable String functionality) {
        return "govno";
    }

    @PostMapping("/{outExtension}")
    public String ChooseOutExtension(@PathVariable String outExtension) {
        return "lol";
    }


}
