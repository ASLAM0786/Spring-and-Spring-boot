package com.aslam.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.aslam.learnspringframework.game")
public class GamingAppLauncherApplication {
  public static void main(String[] args) {
    //1. Launch a spring Context
    try (var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)){
        context.getBean(GamingConsole.class).up();
        context.getBean(GameRunner.class).run();
    }
  }
}
