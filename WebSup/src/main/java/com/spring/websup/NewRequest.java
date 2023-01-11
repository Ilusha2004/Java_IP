package com.spring.websup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cross_cutting.EnumTypes.Extensions;

@RestController
@RequestMapping("api/calculate")

public class NewRequest {


    @GetMapping("add/{firstArg}/{secondArg}")
    public String Add(@PathVariable Extensions firstArg, @PathVariable Double secondArg) {
        return String.format("Hello %s!", firstArg);
    }

}
