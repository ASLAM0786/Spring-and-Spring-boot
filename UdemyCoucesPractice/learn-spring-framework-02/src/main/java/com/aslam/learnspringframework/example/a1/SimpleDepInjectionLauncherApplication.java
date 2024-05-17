package com.aslam.learnspringframework.example.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class SimpleDepInjectionLauncherApplication {
  public static void main(String[] args) {
    //1. Launch a spring Context
    try (var context = new AnnotationConfigApplicationContext(SimpleDepInjectionLauncherApplication.class)){

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
  }
}
