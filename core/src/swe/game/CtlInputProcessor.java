package swe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input;

/**
 * @author Frzifus
 */


public class CtlInputProcessor implements InputProcessor {

  public boolean keyPressed;

  public Pong game;

  CtlInputProcessor(Pong game) {
    this.game = game;
  }

  @Override
  public boolean keyDown(int keycode) {
    return false;
  }

  @Override
  public boolean keyUp(int keycode) {
    if (keycode == Input.Keys.ESCAPE) {
      Gdx.app.exit();
      keyPressed = false;
    }

    if (keycode == Input.Keys.SPACE) {
      if (game.getScreen() == game.gameScreen) {
        game.setScreen(game.pauseScreen);
      } else if (game.getScreen() == game.pauseScreen) {
        game.setScreen(game.gameScreen);
      }
      if (game.getScreen() == game.welcomeScreen) {
        game.setScreen(game.gameScreen);
      }
    }

    return false;
  }

  public boolean keyTyped(char character) {
    //
    return false;
  }

  @Override
  public boolean scrolled(int keycode) {
    return false;
  }

  @Override
  public boolean mouseMoved(int x, int y) {
    return false;
  }

  @Override
  public boolean touchDragged (int x, int y, int pointer) {
    return false;
  }

  @Override
  public boolean touchDown (int x, int y, int pointer, int button) {
    return false;
  }

  @Override
  public boolean touchUp (int x, int y, int pointer, int button) {
    return false;
  }

}
