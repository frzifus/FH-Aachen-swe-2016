package swe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.GL20;

public class Pong extends Game {
  private static final int gameSpeed = 10;

  WelcomeScreen welcomeScreen;
  GameScreen gameScreen;

  @Override
  public void create () {
    welcomeScreen = new WelcomeScreen(this);
    gameScreen = new GameScreen(this);
    setScreen(welcomeScreen);
  }

  @Override
  public void dispose () {
    welcomeScreen.dispose();
    gameScreen.dispose();
  }
}
