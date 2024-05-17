package com.aslam.learnspringboot;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Courses> retriveCousesData(){
        return Arrays.asList(
                new Courses(1,"Learn AWS","learnFromScratch"),
                new Courses(2,"Learn Azure","learnFromScratch"),
                new Courses(3,"Learn GCP","learnFromScratch")
        );
    }
}
