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

  public static String winner;
  public static String loser;

  public String namePlayerOne;
  public String namePlayerTwo;

  public Pong(String namePlayerOne, String namePlayerTwo) {
    this.namePlayerOne = namePlayerOne;
    this.namePlayerTwo = namePlayerTwo;
  }

  @Override
  public void create () {
    gameScreen = new GameScreen(this);
    welcomeScreen = new WelcomeScreen(this);
    endScreen = new EndScreen(this);

    setScreen(welcomeScreen);
  }

  @Override
  public void dispose () {
    welcomeScreen.dispose();
    gameScreen.dispose();
    endScreen.dispose();
  }


}
