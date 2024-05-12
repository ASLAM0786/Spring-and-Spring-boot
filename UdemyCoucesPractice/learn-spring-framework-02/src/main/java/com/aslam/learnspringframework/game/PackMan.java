package com.aslam.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class PackMan implements GamingConsole {
  public void up(){
    System.err.println("PackMan Jump");
  }

  public void down(){
    System.err.println("PackMan Go into whole");
  }

  public void left(){
    System.err.println("PackMan move left");
  }

  public void right(){
    System.err.println("PackMan Move left");
  }

}
