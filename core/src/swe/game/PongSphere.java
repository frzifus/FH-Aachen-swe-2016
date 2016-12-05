package swe.game;



import java.util.Random;
import com.badlogic.gdx.graphics.Texture;
/**
 * @author Frzifus
 */

public class PongSphere extends GameObject {

  float xSpeed;
  float ySpeed;

  Random rand;

  PongSphere() {
    super("SphereImage.png");
    this.sprite.setSize(20f, 20f);
    this.setStartPosition(350, 350);
    this.rand = new Random();
    this.xSpeed = 2.5f;
    this.ySpeed = this.rand.nextFloat() * (1.5f - 0.5f) + 1.5f;
  }

  public void render() {
    batch.begin();
    sprite.draw(batch);
    batch.end();
    move(xSpeed, ySpeed);
  }

  /**
   * @param x
   *        the x to increase sprite position
   * @param y
   *        the y to increase sprite position
   */
  public void move(final float x, final float y) {
    this.sprite.setX(this.sprite.getX() + x);
    this.sprite.setY(this.sprite.getY() + y);
  }


  /**
   * player hit sphere
   */
  public void hitPlayer() {
    this.xSpeed *= -1;
    float nextRnd = this.rand.nextFloat() * (2.5f - 1f) + 2.5f;
    if (yIsPositive()) {
      setYSpeed(nextRnd);
    } else {
      setYSpeed(nextRnd * -1);
    }

  }

  /**
   * @return if y value is positive
   */
  public boolean yIsPositive() {
    return (ySpeed > 0) ? true : false;
  }

  /**
   * @param y to set
   */
  public void setYSpeed(final float y) {
    this.ySpeed = y;
  }

  /**
   *
   */
  public void sphereWantLeaveY() {
    this.ySpeed *= -1;
  }

  /**
   * reset position
   */
  public void resetPosition() {
    this.setStartPosition(350, 350);
  }

}
