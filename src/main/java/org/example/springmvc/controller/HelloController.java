package org.example.springmvc.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/h/*/1")
    public String hello() {
        return "Hello World!";
    }
}
