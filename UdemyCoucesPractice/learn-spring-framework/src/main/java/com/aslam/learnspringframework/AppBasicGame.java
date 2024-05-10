package com.aslam.learnspringframework;

import com.aslam.learnspringframework.game.GameRunner;
import com.aslam.learnspringframework.game.MarioGame;
import com.aslam.learnspringframework.game.SuperContraGame;

public class AppBasicGame {
  public static void main(String[] args) {
    var marioGame = new MarioGame();
    var supperContraGame = new SuperContraGame();
    var gameRunner = new GameRunner(marioGame);
    gameRunner.run();
  }
  
}
