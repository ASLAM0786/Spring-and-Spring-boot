package com.aslam.learnspringframework;

import com.aslam.learnspringframework.game.GameRunner;
import com.aslam.learnspringframework.game.MarioGame;
import com.aslam.learnspringframework.game.PackMan;
import com.aslam.learnspringframework.game.SuperContraGame;

public class AppBasicGame {
  public static void main(String[] args) {

    var game = new MarioGame();
    var gameRunner = new GameRunner(game);
    gameRunner.run();
  }
  
}
