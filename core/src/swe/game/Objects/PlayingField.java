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
    this.centerPlayingField();
  }

  PlayingField(final int x, final int y) {
    super("PlayingFieldImage.jpg");
    this.setSize(x, y);
    this.centerPlayingField();
  }

  public void centerPlayingField() {
    float startX = Gdx.graphics.getWidth()/2f - this.getWidth()/2f;
    float startY = Gdx.graphics.getHeight() - this.getHeight()/1.3f;
    this.setStartPosition(startX, startY);
  }

  public void render() {
    batch.begin();
    sprite.draw(batch);
    batch.end();
  }

}
