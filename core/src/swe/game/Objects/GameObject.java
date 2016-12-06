package swe.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

/**
 * @author Frzifus
 */

public class GameObject {

  /**
   * @see com.badlogic.gdx.graphics.g2d.SpriteBatch
   */
  protected Sprite sprite;

  /**
   * @see com.badlogic.gdx.graphics.SpriteBatch
   */
  protected SpriteBatch batch;

  GameObject(String img) {
    this.sprite = new Sprite(new Texture(img));
    this.batch = new SpriteBatch();
  }

  /**
   * @param positionX
   *        the positionX to set
   * @param positionY
   *        the positionY to set
   */
  public void setStartPosition(final float x, final float y) {
    this.sprite.setPosition(x, y);
  }

  /**
   * @return the spriteBatch
   */
  public Sprite getSprite() {
    return this.sprite;
  }

  /**
   * @see <a href="https://github.com/libgdx/libgdx/wiki/The-life-cycle">The life cycle</a>
   */
  public void dispose() {
    batch.dispose();
  }

  public float getWidth() {
    return sprite.getWidth();
  }

  public float getHeight() {
    return sprite.getHeight();
  }

  public float getX() {
    return this.sprite.getX();
  }

  public float getY() {
    return this.sprite.getY();
  }

  public void setSize(int width, int height) {
    sprite.setSize(width, height);
  }

}
