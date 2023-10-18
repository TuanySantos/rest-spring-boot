package br.com.springboot.restspringboot;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/math")
    public Math math(
            @RequestParam(value = "name", defaultValue = "Test")
            String name) {
        return new Math(counter.incrementAndGet(), String.format(template, name));
    }
}
