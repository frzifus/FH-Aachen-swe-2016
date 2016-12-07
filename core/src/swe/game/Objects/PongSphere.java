package swe.game;

import java.util.Random;
import com.badlogic.gdx.graphics.Texture;

/**
 * @author Frzifus
 */

public class PongSphere extends GameObject {

  private final int xDefault = 250;

  private final int yDefault = 300;

  private float xSpeed;

  private float ySpeed;

  private Random rand;

  private float overallSpeed;

  private boolean hold;

  PongSphere() {
    super("SphereImage.png");
    this.sprite.setSize(5f, 5f);
    this.setStartPosition(xDefault, yDefault);
    this.rand = new Random();
    this.overallSpeed = 1f;
    this.hold = false;
    this.xSpeed = 2.5f * overallSpeed;
    this.ySpeed = this.rand.nextFloat() * (1.5f - 0.5f) + 1.5f * overallSpeed;
  }

  public void toggleHold() {
    if (!this.hold) {
      this.xSpeed = 0;
      this.ySpeed = 0;
      this.hold = true;
    } else {
      this.hold = false;
      // todo
      // resume
    }
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
    this.sprite.setX(this.sprite.getX() + x * this.overallSpeed);
    this.sprite.setY(this.sprite.getY() + y * this.overallSpeed);
  }


  /**
   * player hit sphere
   */
  public void hitPlayer() {
    this.xSpeed *= -1;
    this.overallSpeed += 0.1f;
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
    this.overallSpeed = 1;
    if (this.xSpeed < 0) {
      this.xSpeed *= -1;
    }
    this.setStartPosition(xDefault, yDefault);
  }

}
