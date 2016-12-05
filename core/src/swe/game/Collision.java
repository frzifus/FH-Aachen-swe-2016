package swe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.audio.Sound;

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

  Sound sound;

  Collision(PongPlayer pongPlayerOne, PongPlayer pongPlayerTwo,
            PongSphere pongSphere, PlayingField playingField) {
    this.pongPlayerOne = pongPlayerOne;
    this.pongPlayerTwo = pongPlayerTwo;
    this.pongSphere = pongSphere;
    this.playingField = playingField;
    this.sound = Gdx.audio.newSound(Gdx.files.internal("hit.wav"));
  }

  /**
   * Test
   */
  public void Check() {
    this.SpherePlayerHit();
    this.SphereWantLeaveY();
    this.RefreshScore();
    this.yPlayerLimitation();
  }

  /**
   * Test
   */
  private void SpherePlayerHit() {
    if(Intersector.overlaps(pongPlayerOne.getSprite().getBoundingRectangle(),
                            pongSphere.getSprite().getBoundingRectangle()) ||
       Intersector.overlaps(pongPlayerTwo.getSprite().getBoundingRectangle(),
                            pongSphere.getSprite().getBoundingRectangle())
       ) {
      sound.play();
      pongSphere.hitPlayer();
    }
  }

  /**
   * Test
   */
  private void SphereWantLeaveY() {
    if (!Intersector.overlaps(playingField.getSprite().getBoundingRectangle(),
                            pongSphere.getSprite().getBoundingRectangle())) {
      pongSphere.sphereWantLeaveY();
    }
  }

  /**
   * refresh score if plaer score1
   */
  private void RefreshScore() {
    if (playingField.getX() > pongSphere.getX()) {
      pongPlayerOne.reduceLife();
      pongSphere.resetPosition();
    } else if (playingField.getX()
               + playingField.getWidth() < pongSphere.getX()) {
      pongPlayerTwo.reduceLife();
      pongSphere.resetPosition();
    }
  }

  /**
   * #magic!!
   */
  public void yPlayerLimitation() {
    if (playingField.getY() >= pongPlayerOne.getY()) {
      pongPlayerOne.setMoveDownDirective(0);
    } else {
      pongPlayerOne.setMoveDownDirective(1);
    }
    // magic
    if (479 < pongPlayerOne.getY()) {
      pongPlayerOne.setMoveUpDirective(0);
    } else {
      pongPlayerOne.setMoveUpDirective(1);
    }

    if (playingField.getY() >= pongPlayerTwo.getY()) {
      pongPlayerTwo.setMoveDownDirective(0);
    } else {
      pongPlayerTwo.setMoveDownDirective(1);
    }

    // magic
    if (480 <= pongPlayerTwo.getY()) {
      pongPlayerTwo.setMoveUpDirective(0);
    } else {
      pongPlayerTwo.setMoveUpDirective(1);
    }
  }

  public void dispose() {
    sound.dispose();
  }

}
