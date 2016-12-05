package swe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input;

/**
 * @author Frzifus
 */

public class WelcomeScreen implements Screen {

  /**
   * hold reference to game
   */
  public Pong game;

  /**
   * hold reference to game
   */
  SpriteBatch greetings;

  /**
   *
   */
  BitmapFont font;

  /**
   * hold reference to game
   */
  String greetingsMsg = "Space to enter!";

  /**
   *  Constructor
   * @param reference of game
   *                  create two new players and hold a reference of game
   */
  WelcomeScreen(Pong game) {
    this.game = game;
    greetings = new SpriteBatch();
    font = new BitmapFont();
    font.setColor(0.5f,0.4f,0,1);
  }

  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(1, 1, 0, 0);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    greetings.begin();
    // magic lulz
    font.draw(greetings, greetingsMsg, 350, 350);
    greetings.end();

    if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
       game.setScreen(game.gameScreen);
    } else if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
      Gdx.app.exit();
    }
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
