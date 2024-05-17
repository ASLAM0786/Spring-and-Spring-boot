package com.aslam.learnspringframework.example.f1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XMLConfigurationApplicationLauncher {
  public static void main(String[] args) {
    //1. Launch a spring Context
    try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")){

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
  }
}
