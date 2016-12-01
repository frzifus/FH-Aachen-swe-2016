package swe.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class PongPlayer {
  private String name;
  private int liveLeft;
  private int width;
  private int height;
  private int positionX;
  private int positionY;

  private SpriteBatch pSprite;
  private Texture pTexture;

  PongPlayer() {
    this.name = "default";
    this.liveLeft = 3;
    this.width = 10;
    this.height = 80;
    this.positionX = 10;
    this.positionY = 10;
    this.pSprite = new SpriteBatch();
    this.pTexture = new Texture("PaddleImage.jpg");
  }

  public void render() {
    this.pSprite.begin();
    this.pSprite.draw(this.pTexture, this.positionX, this.positionY,
                      this.width, this.height);
    this.pSprite.end();
  }

  public void dispose() {
    this.pSprite.dispose();
    this.pTexture.dispose();
  }

  public void MoveUp(int x) {}
  public void MoveDown(int x) {}

}
