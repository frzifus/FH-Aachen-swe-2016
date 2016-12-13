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

  public CtlInputProcessor ctlInputProcessor;

  PauseScreen(Pong game) {
    this.game = game;
    msgBatch = new SpriteBatch();
    font = new BitmapFont();
    font.setColor(0.5f,0.4f,0,1);
    ctlInputProcessor = new CtlInputProcessor(game);
    Gdx.input.setInputProcessor(ctlInputProcessor);
  }

  @Override
  public void render(float delta) {

    Gdx.gl.glClearColor(0, 0, 0, 0);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


    msgBatch.begin();
    // magic lulz
    font.draw(msgBatch, pauseMsg, 320, 350);
    msgBatch.end();

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
