package swe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input.Keys;

/**
 * @author Frzifus
 */

public class PauseScreen implements Screen {

  /**
   * hold reference to game
   */
  public Pong game;

  /**
   * hold reference to game
   */
  private SpriteBatch msgBatch;

  /**
   *
   */
  private BitmapFont font;

  /**
   * hold reference to game
   */
  private String pauseMsg = "Leertaste zum weiterspielen...";



  PauseScreen(Pong game) {
    this.game = game;
    msgBatch = new SpriteBatch();
    font = new BitmapFont();
    font.setColor(0.5f,0.4f,0,1);

  }

  @Override
  public void render(float delta) {

    msgBatch.begin();
    // magic lulz
    font.draw(msgBatch, pauseMsg, 350, 350);
    msgBatch.end();

    Gdx.gl.glClearColor(1, 1, 0, 0);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


    if(Gdx.input.isKeyPressed(Keys.SPACE)) {
      game.setScreen(game.gameScreen);
    } else if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
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
  }

}
