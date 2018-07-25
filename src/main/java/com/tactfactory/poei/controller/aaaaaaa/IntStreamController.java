package com.tactfactory.poei.controller.aaaaaaa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntStreamController {
    private int counter = 0;

    @GetMapping("a/intstream")
    public Map<String, String> process() {
        ++ this.counter;

        String value = IntStream
            .range(0, counter)                  // Loop.
            .mapToObj(a -> "a")                 // 'a' creations
            .collect(Collectors.joining(""));   // Concatenation.

        return Collections.singletonMap("value", value);
    }

    @SuppressWarnings("all")
    private void functionnalLoops() {
        for (int i = 0; i < 5; ++i) {
            System.out.println(i);
        }

        IntStream.range(0, 5).forEach(System.out::println);

        IntStream.iterate(0, v -> v + 2).limit(12).forEach(System.out::println);
    }

    public long fact(int a) {
        return IntStream.rangeClosed(1, a).reduce(1, (acc, v) -> acc * v);
    }

    @SuppressWarnings("all")
    private void functionnalSimpleExamples() {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(3);
        l.add(4);
        l.add(42);
        l.add(6);

        forEachExamples(l);

        mapExample(l);
    }

    @SuppressWarnings("all")
    private void mapExample(ArrayList<Integer> l) {
        {
            List<Integer> square = new ArrayList<>();

            for (int v : l) {
                square.add(v * v);
            }
        }

        {
            List<Integer> square = l.stream().map(v -> v * v).collect(Collectors.toList());
        }
    }

    @SuppressWarnings("all")
    private void forEachExamples(ArrayList<Integer> l) {
        for (int value : l) {
            System.out.println(value);
        }

        for (int value : l) {
            this.noLambda(value);
        }

        l.forEach(value -> System.out.println(value));

        l.forEach(System.out::println);
    }

    public void noLambda(int value) {
        System.out.println(value);
    }
}
