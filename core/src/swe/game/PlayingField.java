package swe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * @author Frzifus
 */

public class PlayingField extends GameObject {

  PlayingField() {
    super("PlayingFieldImage.jpg");
    this.setSize(600, 400);
    float startX = Gdx.graphics.getWidth()/2f - this.getWidth()/2f;
    float startY = Gdx.graphics.getHeight() - this.getHeight()/1.2f;
    this.setStartPosition(startX, startY);
  }

  public void render() {
    batch.begin();
    sprite.draw(batch);
    batch.end();
  }

}
