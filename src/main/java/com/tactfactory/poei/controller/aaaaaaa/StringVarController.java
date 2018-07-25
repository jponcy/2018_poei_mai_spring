package com.tactfactory.poei.controller.aaaaaaa;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringVarController {
    private String value = "";
    
    @GetMapping("a/string")
    public Map<String, String> process() {
        value += "a";
        return Collections.singletonMap("value", value);
    }
}
