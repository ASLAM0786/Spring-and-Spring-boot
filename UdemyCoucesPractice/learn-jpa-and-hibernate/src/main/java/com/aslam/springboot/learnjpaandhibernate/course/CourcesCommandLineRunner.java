package com.aslam.springboot.learnjpaandhibernate.course;

import com.aslam.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.aslam.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.aslam.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourcesCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
//        repository.insert(new Course(1,"Learn AWS JPA","LearnFromScratch"));
//        repository.insert(new Course(2,"Learn Azure JPA","LearnFromScratch"));
//        repository.insert(new Course(3,"Learn Devops JPA","LearnFromScratch"));
//
//        repository.deleteById(2);
//
//        repository.findById(1);
//        repository.findById(3);

        repository.save(new Course(1,"Learn AWS Spring Data JPA","LearnFromScratch"));
        repository.save(new Course(2,"Learn Azure  Spring Data JPA","LearnFromScratch"));
        repository.save(new Course(3,"Learn Devops  Spring Data JPA","LearnFromScratch"));

        repository.deleteById(2l);

        repository.findById(1l);
        repository.findById(3l);

        repository.findByAuthor("LearnFromScratch");
        repository.findByAuthor("");

        repository.findByName("Learn AWS Spring Data JPA");
        repository.findByName("Learn Azure  Spring Data JPA");

    }
}
