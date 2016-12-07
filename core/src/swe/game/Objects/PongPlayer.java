package swe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Input;


/**
 * @author Frzifus
 */

public class PongPlayer extends GameObject {

  /**
   * player name
   */
  private String name;

  /**
   * number of remaining players life
   */
  private int lifeLeft;

  /**
   * Key to move up
   */
  private int keyUp;

  /**
   * Key to move down
   */
  private int keyDown;

  private int moveDownDirective;

  private int moveUpDirective;

  private int playerSpeed;

  private TestBot testBot;

  /**
   * Constructor with default name, lifeLeft, widht, height,
   *                          positionX, positionY, batch and texture
   */
  PongPlayer() {
    super("PaddleImage.jpg");
    this.name = "default";
    this.lifeLeft = 3;
    this.moveUpDirective = 1;
    this.moveDownDirective = 1;
    this.sprite.setSize(10f, 73f);
    this.playerSpeed = 10;
    this.keyUp = Input.Keys.DPAD_UP;
    this.keyDown = Input.Keys.DPAD_DOWN;
  }

  /**
   * @see <a href="https://github.com/libgdx/libgdx/wiki/The-life-cycle">The life cycle</a>
   */
  public void render() {
    batch.begin();
    sprite.draw(batch);
    batch.end();
  }

  /**
   * @param y
   *        the y to increase Y
   */
  public void MoveUp() {
    int var = this.playerSpeed * moveUpDirective;
    this.sprite.setY(this.sprite.getY() + (this.playerSpeed * moveUpDirective));
  }

  /**
   *
   */
  public void setMoveUpDirective(int y) {
    this.moveUpDirective = y;
  }

  /**
   *
   */
  public void setMoveDownDirective(int y) {
    this.moveDownDirective = y;
  }

  /**
   * @param y
   *        the y to reduce Y
   */
  public void MoveDown() {
    int var = this.playerSpeed * moveDownDirective;
    this.sprite.setY(this.sprite.getY() - var);
  }

  /**
   * @param name
   *        the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param life
   *        the life to set
   */
  public void setLifeLeft(int life) {
    this.lifeLeft = life;
  }

  /**
   * @param life
   *        the life to set
   */
  public int getLifeLeft() {
    return this.lifeLeft;
  }

  /**
   * reduce lifeLeft by one
   */
  public void reduceLife() {
    this.lifeLeft -= 1;
  }

  /**
   * @return life status
   *              check if player is still alive
   */
  public boolean isStillAlive() {
    return (this.lifeLeft < 1) ? false : true;
  }

  /**
   * @param widht
   *        the widht to set
   * @param height
   *        the height to set
   */
  public void resizePlayer(float width, float height) {
    this.sprite.setSize(width, height);
  }

  /**
   * @param Keys to move up
   *
   * @param Keys to move down
   *
   */
  public void setInputKeys(int keyUp, int keyDown) {
    this.keyUp = keyUp;
    this.keyDown = keyDown;
  }

  /**
   * @param gameSpeed
   *        Influences the speed of the paddle
   *
   */
  public void checkInput(int gameSpeed) {
    if(this.testBot != null) {
      this.testBot.Move();
      return;
    }
    if(Gdx.input.isKeyPressed(this.keyUp)) {
      MoveUp();
    } else if(Gdx.input.isKeyPressed(this.keyDown)) {
      MoveDown();
    }

  }

  public void ActivateBot(PongSphere pongSphere) {
    this.testBot = new TestBot(this, pongSphere);
  }

  public void setPlayerSpeed(int playerSpeed) {
    this.playerSpeed = playerSpeed;
  }

  public int getPlayerSpeed() {
    return this.playerSpeed;
  }

}
