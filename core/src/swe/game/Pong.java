package swe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.GL20;

/**
 * @author Frzifus
 */

public class Pong extends Game {

  WelcomeScreen welcomeScreen;
  GameScreen gameScreen;

  @Override
  public void create () {
    gameScreen = new GameScreen(this);
    welcomeScreen = new WelcomeScreen(this);
    setScreen(welcomeScreen);
  }

  @Override
  public void dispose () {
    welcomeScreen.dispose();
    gameScreen.dispose();
  }
}
