package swe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Input.Keys;

/**
 * @author Frzifus
 */

public class EndScreen implements Screen {

  /**
   * hold reference to game
   */
  Pong game;

  /**
   * endScreen timer
   */
  double startTime;

  /**
   * hold reference to scoreBoard
   */
  ScoreBoard scoreBoard;


  EndScreen(Pong game, ScoreBoard scoreBoard) {
    this.game = game;
    this.scoreBoard = scoreBoard;
  }

  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(0, 0, 0, 0);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    scoreBoard.showWinner();
    if (Gdx.input.isKeyPressed(Keys.SPACE) ||
        Gdx.input.isKeyPressed(Keys.ESCAPE)) {
        scoreBoard.printResJson();
        Gdx.app.exit();
      }

  }

  @Override
  public void resize(int width, int height) {}

  @Override
  public void show() {}

  @Override
  public void hide() {
    // called when current screen changes from this to a different screen
  }

  @Override
  public void pause() {}

  @Override
  public void resume() {}

  @Override
  public void dispose() {}

}
