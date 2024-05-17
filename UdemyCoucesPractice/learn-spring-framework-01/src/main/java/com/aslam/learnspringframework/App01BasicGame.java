package com.aslam.learnspringframework;

import com.aslam.learnspringframework.game.GameRunner;
import com.aslam.learnspringframework.game.MarioGame;
import com.aslam.learnspringframework.game.PackMan;
import com.aslam.learnspringframework.game.SuperContraGame;

public class App01BasicGame {
  public static void main(String[] args) {

    var game = new PackMan(); //1. Object Creation
    var gameRunner = new GameRunner(game); //2. Object creation + wiring dependencies . game is dependencies of GameRunner
    gameRunner.run();
  }
  
}
