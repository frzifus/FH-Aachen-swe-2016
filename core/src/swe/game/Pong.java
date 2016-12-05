package swe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.GL20;

/**
 * @author Frzifus
 */

public class Pong extends Game {

  public WelcomeScreen welcomeScreen;
  public GameScreen gameScreen;
  public EndScreen endScreen;
  public PauseScreen pauseScreen;

  public ScoreBoard scoreBoard;

  public String playerOneName;
  public String playerTwoName;

  public Pong(String playerOneName, String playerTwoName) {
    this.playerOneName = playerOneName;
    this.playerTwoName = playerTwoName;
  }

  @Override
  public void create () {
    scoreBoard = new ScoreBoard(playerOneName, playerTwoName);
    welcomeScreen = new WelcomeScreen(this, scoreBoard);
    gameScreen = new GameScreen(this, scoreBoard);
    endScreen = new EndScreen(this, scoreBoard);
    pauseScreen = new PauseScreen(this);
    setScreen(welcomeScreen);
  }

  @Override
  public void dispose () {
    welcomeScreen.dispose();
    gameScreen.dispose();
  }

}
