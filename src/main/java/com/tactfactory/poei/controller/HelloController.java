package com.tactfactory.poei.controller;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static Integer counter = 0;

    @RequestMapping("counter")
    public Map<String, Integer> count() {
        ++ counter;
        return cc();
    }

    @RequestMapping("hello")
    public Map<String, String> hello(
            // Les quatres lignes suivantes sont strictement équivalentes dans ce cas.
            @RequestParam String name
//            @RequestParam("name") String name
//            @RequestParam(value = "name") String name
//            @RequestParam(name = "name") String name
    ) {
        String message = "Salut " + name;
        return Collections.singletonMap("message", message);
    }

    @RequestMapping("inc")
    public Map<String, Integer> increment(@RequestParam(defaultValue = "1") String nb) {
        counter = counter + Integer.parseInt(nb);

        return cc();
    }

    @RequestMapping("reset")
    public Map<String, Integer> reset() {
        counter = 0;
        return cc();
    }
    

    private Map<String, Integer> cc() {
        return Collections.singletonMap("count", counter);
    }
}
