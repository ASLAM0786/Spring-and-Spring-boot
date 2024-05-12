package com.aslam.springboot.myfirstwebapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {
    @RequestMapping("/")
    public String sayHello(){
        return "Hello ! What are you learning today";
    }
}
