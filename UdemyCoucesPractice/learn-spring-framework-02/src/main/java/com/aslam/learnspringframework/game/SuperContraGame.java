package com.aslam.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole  {
  public void up(){
    System.err.println("Super Jump");
  }

  public void down(){
    System.err.println("Super Go into whole");
  }

  public void left(){
    System.err.println("Super move left");
  }

  public void right(){
    System.err.println("Super Move left");
  }
}
