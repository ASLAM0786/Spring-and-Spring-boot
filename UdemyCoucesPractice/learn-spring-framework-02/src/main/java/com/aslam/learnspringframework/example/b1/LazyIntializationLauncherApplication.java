package com.aslam.learnspringframework.example.b1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class  ClassA{

}

@Component
@Lazy
class  ClassB{

    private ClassA classA;

    public ClassB(ClassA classA){
        System.out.println("Some Initialization Logic");
        this.classA = classA;
    }

    public void doSomething(){
        System.out.println("Do somethings");
    }

}
@Configuration
@ComponentScan
public class LazyIntializationLauncherApplication {
  public static void main(String[] args) {
    //1. Launch a spring Context
    try (var context = new AnnotationConfigApplicationContext(LazyIntializationLauncherApplication.class)){

        System.out.println("Initialization of context is completed");
       // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        context.getBean(ClassB.class).doSomething();
    }
  }
}
