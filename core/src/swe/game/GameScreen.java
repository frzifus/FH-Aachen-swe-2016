package swe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * @author Frzifus
 */

public class GameScreen implements Screen {

  /**
   * static const gameSpeed
   */
  private static final int gameSpeed = 10;

  /**
   * player one (left)
   */
  private PongPlayer playerOne;

  /**
   * player two (right)
   */
  private PongPlayer playerTwo;

  /**
   * hold reference to game
   */
  public Pong game;

  /**
   *  Constructor
   * @param reference of game
   *                  create two new players and hold a reference of game
   */
  GameScreen(Pong game) {
    this.game = game;
    this.playerOne = new PongPlayer();
    this.playerTwo = new PongPlayer();
    this.playerTwo.setStartPosition(780, 10);
  }

  @Override
  public void render(float delta) {
    this.playerOne.checkInput(gameSpeed);
    this.playerTwo.checkInput(gameSpeed);

    Gdx.gl.glClearColor(1, 1, 0, 0);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    this.playerOne.render();
    this.playerTwo.render();
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
    this.playerOne.dispose();
  }

}
