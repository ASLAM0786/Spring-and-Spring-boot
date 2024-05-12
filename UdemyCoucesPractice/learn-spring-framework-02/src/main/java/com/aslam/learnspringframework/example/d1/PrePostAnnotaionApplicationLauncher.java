package com.aslam.learnspringframework.example.d1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency){
        super();
        this.someDependency = someDependency;
        System.out.println("All Dependency are ready!!");
    }

    @PostConstruct
    public void intialize(){
            someDependency.getReady();
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("CleanUp!!");
    }
}

@Component
class SomeDependency{

    public void getReady() {
        System.out.println("Get ready for Post Construct");
    }
}


@Configuration
@ComponentScan
public class PrePostAnnotaionApplicationLauncher {
  public static void main(String[] args) {
    //1. Launch a spring Context
    try (var context = new AnnotationConfigApplicationContext(PrePostAnnotaionApplicationLauncher.class)){

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
  }
}
