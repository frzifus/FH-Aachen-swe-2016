package swe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * @author Frzifus
 */

public class WelcomeScreen implements Screen {

  /**
   * hold reference to game
   */
  public Pong game;

  /**
   *  Constructor
   * @param reference of game
   *                  create two new players and hold a reference of game
   */
  WelcomeScreen(Pong game) {
    this.game = game;
  }

  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(1, 1, 0, 0);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    // if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
    //   game.setScreen(gameScreen);
    // }
    // use your own criterion here game.setScreen(game.anotherScreen);
  }

  @Override
  public void resize(int width, int height) {}

  @Override
  public void show() {
    // called when this screen is set as the screen with game.setScreen();
  }

  @Override
  public void hide() {
    // called when current screen changes from this to a different screen
  }

  @Override
  public void pause() {}

  @Override
  public void resume() {}

  @Override
  public void dispose() {
    // never called automatically
  }

}
