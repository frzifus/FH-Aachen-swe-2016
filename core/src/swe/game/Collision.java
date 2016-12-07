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
    this.yPlayerLimitation(this.pongPlayerOne);
    this.yPlayerLimitation(this.pongPlayerTwo);
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
    if (pongSphere.getY() + (1.5 * pongSphere.getHeight()) >=
        playingField.getY() + playingField.getHeight()) {
      pongSphere.sphereWantLeaveY();
    }

    if (pongSphere.getY() - pongSphere.getHeight() < playingField.getY()) {
      pongSphere.sphereWantLeaveY();
    }
  }

  /**
   * refresh score if plaer score1
   */
  private void RefreshScore() {
    if (playingField.getX() > pongSphere.getX() + pongSphere.getWidth()) {
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
  public void yPlayerLimitation(PongPlayer pongPlayer) {
    if (playingField.getY() > pongPlayer.getY() - 10) {
      pongPlayer.setMoveDownDirective(0);
    } else {
      pongPlayer.setMoveDownDirective(1);
    }

    if (playingField.getHeight() - 20 <= pongPlayer.getY()) {
      pongPlayer.setMoveUpDirective(0);
    } else {
      pongPlayer.setMoveUpDirective(1);
    }
  }

  public void dispose() {
    sound.dispose();
  }

}
