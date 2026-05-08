package com.aslam.learn_spring_security.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    @GetMapping("/")
    public String HelloWorld(){
        return "Hello World";
    }
}
