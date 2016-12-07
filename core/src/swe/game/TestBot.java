package swe.game;

/**
 * @author Frzifus
 */

public class TestBot {


  /**
   * reference to playerBot
   */
  private PongSphere pongSphere;

  /**
   * reference to playerBot
   */
  private PongPlayer playerBot;

  /**
   *
   */
  private float yPosition;

  TestBot(PongPlayer playerBot, PongSphere pongSphere) {
    this.pongSphere = pongSphere;
    this.playerBot = playerBot;
  }

  public void Move() {  // split this
    this.yPosition = this.playerBot.getY() + (this.playerBot.getHeight()/2);
    if (this.playerBot.getX() > 350) { // isPlayerTwo
      if (this.pongSphere.getX() < 350) {
        return;
      }
    }

    if (this.playerBot.getX() < 350) { // isPlayerOne
      if (this.pongSphere.getX() > 350) {
        return;
      }
    }

    if (this.yPosition > pongSphere.getY() + 5) {
      this.playerBot.MoveDown(5);
    } else if (this.yPosition < pongSphere.getY() - 5) {
      this.playerBot.MoveUp(5);
    }
  }
}
