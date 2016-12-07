package swe.game;

/**
 * @author Frzifus
 */

public class TestBot {


  /**
   * reference to playerTwo
   */
  private PongSphere pongSphere;

  /**
   * reference to playerTwo
   */
  private PongPlayer playerTwo;

  /**
   *
   */
  private float yPosition;

  TestBot(PongSphere pongSphere, PongPlayer playerTwo) {
    this.pongSphere = pongSphere;
    this.playerTwo = playerTwo;
  }

  public void move() {
    this.yPosition = this.playerTwo.getY() + (this.playerTwo.getHeight()/2);
    if (this.pongSphere.getX() < 350) {
      return;
    }
    if (this.yPosition > pongSphere.getY() + 5) {
      this.playerTwo.MoveDown(5);
    } else if (this.yPosition < pongSphere.getY() - 5) {
      this.playerTwo.MoveUp(5);
    }
  }
}
