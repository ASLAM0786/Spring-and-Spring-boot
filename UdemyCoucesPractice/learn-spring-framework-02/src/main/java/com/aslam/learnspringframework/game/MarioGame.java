package com.aslam.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole {
  public void up(){
    System.err.println("Jump");
  }

  public void down(){
    System.err.println("Go into whole");
  }

  public void left(){
    System.err.println("move left");
  }

  public void right(){
    System.err.println("Move left");
  }
}
