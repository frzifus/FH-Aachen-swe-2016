package swe.game;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.graphics.g2d.Sprite;


/**
 * @author Frzifus
 */

public class Collision {

  /**
   * reference to playerOne
   */
  PongPlayer pongPlayerOne;

  /**
   * reference to playerTwo
   */
  PongPlayer pongPlayerTwo;

  /**
   * reference to pongSphere
   */
  PongSphere pongSphere;

  /**
   * reference to playingField
   */
  PlayingField playingField;

  Collision(PongPlayer pongPlayerOne, PongPlayer pongPlayerTwo,
            PongSphere pongSphere, PlayingField playingField) {
    this.pongPlayerOne = pongPlayerOne;
    this.pongPlayerTwo = pongPlayerTwo;
    this.pongSphere = pongSphere;
    this.playingField = playingField;
  }

  /**
   * Test
   */
  void Check() {
    this.SpherePlayerHit();
    this.SphereWantLeaveY();
    this.RefreshScore();
  }

  /**
   * Test
   */
  void SpherePlayerHit() {
    if(Intersector.overlaps(pongPlayerOne.getSprite().getBoundingRectangle(),
                            pongSphere.getSprite().getBoundingRectangle()) ||
       Intersector.overlaps(pongPlayerTwo.getSprite().getBoundingRectangle(),
                            pongSphere.getSprite().getBoundingRectangle())
       ) {
      pongSphere.hitPlayer();
    }
  }

  /**
   * Test
   */
  void SphereWantLeaveY() {
    if (!Intersector.overlaps(playingField.getSprite().getBoundingRectangle(),
                            pongSphere.getSprite().getBoundingRectangle())) {
      pongSphere.sphereWantLeaveY();
    }
  }

  /**
   * refresh score if plaer score1
   */
  void RefreshScore() {
    if (playingField.getX() > pongSphere.getX()) {
      pongPlayerOne.reduceLife();
      pongSphere.resetPosition();
    } else if (playingField.getX()
               + playingField.getWidth() < pongSphere.getX()) {
      pongPlayerTwo.reduceLife();
      pongSphere.resetPosition();
    }
  }
}
