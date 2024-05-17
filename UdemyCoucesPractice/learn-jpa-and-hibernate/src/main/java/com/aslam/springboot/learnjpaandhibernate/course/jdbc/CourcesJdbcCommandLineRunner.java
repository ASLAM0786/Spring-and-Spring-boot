//package com.aslam.springboot.learnjpaandhibernate.course.jdbc;
//
//import com.aslam.springboot.learnjpaandhibernate.course.Course;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CourcesJdbcCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJdbcRepository repository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        repository.insert(new Course(1,"Learn AWS","LearnFromScratch"));
//        repository.insert(new Course(2,"Learn Azure","LearnFromScratch"));
//        repository.insert(new Course(3,"Learn Devops","LearnFromScratch"));
//
//        repository.deleteById(1);
//
//        repository.findById(2);
//        repository.findById(3);
//    }
//}
