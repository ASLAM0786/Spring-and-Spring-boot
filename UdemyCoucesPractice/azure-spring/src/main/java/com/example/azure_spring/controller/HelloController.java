package com.example.azure_spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/greet")
    public String name(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello "+name;
    }
}