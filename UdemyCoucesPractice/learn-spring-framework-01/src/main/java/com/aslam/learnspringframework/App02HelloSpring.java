package com.aslam.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloSpring {
  public static void main(String[] args) {
    //1. Launch a spring Context
    var context = new AnnotationConfigApplicationContext(HelloWorldSpringConfiguration.class);

    //2. Configure the things which we want spring to manage --@Configuration
    System.err.println(context.getBean("name"));
    System.err.println(context.getBean("Age"));
    System.err.println(context.getBean("person"));
    System.err.println(context.getBean("person2MtodCall"));
    System.err.println(context.getBean("person3MtodCall"));
    System.err.println(context.getBean("address2"));

  }
  
}
