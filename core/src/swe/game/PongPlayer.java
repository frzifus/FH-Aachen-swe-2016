package swe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Input;

/**
 * @author Frzifus
 */

public class PongPlayer {
  /**
   * player name
   */
  private String name;

  /**
   * number of remaining players life
   */
  private int lifeLeft;

  /**
   * width of the paddle
   */
  private int width;

  /**
   * height of the paddle
   */
  private int height;

  /**
   * x position...
   */
  private int positionX;

  /**
   * y position...
   */
  private int positionY;

  /**
   * @see com.badlogic.gdx.graphics.g2d.SpriteBatch
   */
  private SpriteBatch pSprite;

  /**
   * @see com.badlogic.gdx.graphics.Texture
   */
  private Texture pTexture;

  /**
   * Constructor with default name, lifeLeft, widht, height,
   *                          positionX, positionY, pSprite and pTexture
   */
  PongPlayer() {
    this.name = "default";
    this.lifeLeft = 3;
    this.width = 10;
    this.height = 80;
    this.positionX = 10;
    this.positionY = 360;
    this.pSprite = new SpriteBatch();
    this.pTexture = new Texture("PaddleImage.jpg");
  }

  /**
   * @see <a href="https://github.com/libgdx/libgdx/wiki/The-life-cycle">The life cycle</a>
   */
  public void render() {
    this.pSprite.begin();
    this.pSprite.draw(this.pTexture, this.positionX, this.positionY,
                      this.width, this.height);
    this.pSprite.end();
  }

  /**
   * @see <a href="https://github.com/libgdx/libgdx/wiki/The-life-cycle">The life cycle</a>
   */
  public void dispose() {
    this.pSprite.dispose();
    this.pTexture.dispose();
  }

  /**
   * @param y
   *        the y to increase positionY
   */
  public void MoveUp(int y) {
    this.positionY += y;
  }

  /**
   * @param y
   *        the y to reduce positionY
   */
  public void MoveDown(int y) {
    this.positionY -= y;
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
   * reduce lifeLeft by one
   */
  public void reduceLife() {
    this.lifeLeft -= 1;
  }

  /**
   * @return life status
   *              check if player is still alive
   */
  public boolean stillAlive() {
    return (this.lifeLeft < 0) ? false : true;
  }

  /**
   * @param widht
   *        the widht to set
   * @param height
   *        the height to set
   */
  public void resizePlayer(int width, int height) {
    this.width = width;
    this.height = height;
  }

  /**
   * @param positionX
   *        the positionX to set
   * @param positionY
   *        the positionY to set
   */
  public void setStartPosition(int positionX, int positionY) {
    this.positionX = positionX;
    this.positionY = positionY;
  }

  /**
   * @param key to move up
   *
   * @param key to move down
   *
   */
  public void setInputKeys(int up, int down) {}

  /**
   * @param gameSpeed
   *        Influences the speed of the paddle
   *
   *  # We should ask ourselves if this is the right place
   */
  public void checkInput(int gameSpeed) {
    if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
      MoveUp(1 * gameSpeed);
    } else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
      MoveDown(1 * gameSpeed);
    }

  }
}
