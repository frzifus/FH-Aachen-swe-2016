package swe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Input.Keys;

public class GameScreen implements Screen {

  private PongPlayer playerOne;
  public Pong game;

  GameScreen(Pong game) {
    this.game = game;
    this.playerOne = new PongPlayer();
  }

  @Override
  public void render(float delta) {

    // if(Gdx.input.isKeyPressed(Keys.DPAD_UP)) {
    //   playerOne.MoveUp(Gdx.graphics.getDeltaTime() * gameSpeed);
    // }
    // if(Gdx.input.isKeyPressed(Keys.DPAD_DOWN)) {
    //   playerOne.MoveDown(Gdx.graphics.getDeltaTime() * gameSpeed);
    // }


    Gdx.gl.glClearColor(1, 1, 0, 0);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    this.playerOne.render();
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

  @Override public void pause() {}

  @Override public void resume() {}

  @Override public void dispose() {
    this.playerOne.dispose();
  }

}
