package com.aslam.springboot.learnjpaandhibernate.course.springdatajpa;

import com.aslam.springboot.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long> {
    // to create custom query which not provided by spring data jpa --create something like this.

    List<Course> findByAuthor(String author);

    List<Course> findByName(String name);
}
