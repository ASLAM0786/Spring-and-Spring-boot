package com.aslam.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HellWorldBean helloWorldBean() {
        return new HellWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HellWorldBean helloWorldPathVariable(@PathVariable String name) {

        return new HellWorldBean(String.format("Hello World %s", name));
    }
}
