package com.tactfactory.poei.controller.aaaaaaa;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntForController {
    private static int counter = 0;

    @GetMapping("a/intfor")
    public Map<String, String> process() {
        String value = "";
        ++ counter;
        
        for (int i = 0; i < counter; ++ i) {
            value += "a";
        }
        
        return Collections.singletonMap("value", value);
    }
}
