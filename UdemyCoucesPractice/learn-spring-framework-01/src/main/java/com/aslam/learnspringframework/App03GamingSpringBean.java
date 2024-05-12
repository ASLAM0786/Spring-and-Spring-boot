package com.aslam.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aslam.learnspringframework.game.GameRunner;
import com.aslam.learnspringframework.game.GamingConsole;

public class App03GamingSpringBean {
  public static void main(String[] args) {
    //1. Launch a spring Context
    try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
        context.getBean(GamingConsole.class).up();
        context.getBean(GameRunner.class).run();
    }
  }
}
