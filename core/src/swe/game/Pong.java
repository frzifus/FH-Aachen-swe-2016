package swe.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Input.Keys;

public class Pong extends ApplicationAdapter {
  private static final int gameSpeed = 10;

  PongPlayer PlayerOne;

  @Override
  public void create () {
    PlayerOne = new PongPlayer();
  }

  @Override
  public void render () {
    // if(Gdx.input.isKeyPressed(Keys.DPAD_UP)) {
    //   PlayerOne.MoveUp(Gdx.graphics.getDeltaTime() * gameSpeed);
    // }
    // if(Gdx.input.isKeyPressed(Keys.DPAD_DOWN)) {
    //   PlayerOne.MoveDown(Gdx.graphics.getDeltaTime() * gameSpeed);
    // }

    Gdx.gl.glClearColor(1, 1, 0, 0);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    PlayerOne.render();
  }

  @Override
  public void dispose () {
    PlayerOne.dispose();
  }
}
