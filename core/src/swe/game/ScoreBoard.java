package swe.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Frzifus
 */

public class ScoreBoard {

  /**
   * player one
   */
  private PongPlayer playerOne;

  /**
   * player two
   */
  private PongPlayer playerTwo;


  /**
   * winner
   */
  private String winner;


  /**
   * loser
   */
  private String loser;

  /**
   * @see com.badlogic.gdx.graphics.g2d.SpriteBatch
   */
  private SpriteBatch spriteBatch;

  /**
   * hold reference to game
   */
  SpriteBatch display;

  /**
   *
   */
  BitmapFont font;

  ScoreBoard(String playerOneName, String playerTwoName) {
    this.playerOne = new PongPlayer();
    this.playerTwo = new PongPlayer();
    this.playerOne.setName(playerOneName);
    this.playerTwo.setName(playerTwoName);
    display = new SpriteBatch();
    font = new BitmapFont();
    font.setColor(0.5f,0.4f,0,1);
  }


  /**
   * @return if someone die
   */
  public boolean CheckSomeoneDie() {
    if(!playerOne.isStillAlive()) {
      this.winner = playerTwo.getName();
      this.loser  = playerOne.getName();
      return true;
    } else if (!playerTwo.isStillAlive()) {
      this.winner = playerOne.getName();
      this.loser  = playerTwo.getName();
      return true;
    }
    return false;
  }

  /**
   * print match resault
   */
  public void printResJson() {
    // json...
    System.out.println("{\"winner\":\"" + this.winner + "\", " +
                       "\"loser\":\"" + this.loser + "\"}");
  }

  public void showScore() {
    display.begin();
    // magic lulz
    font.draw(display, playerOne.getName() + ": " +
              playerOne.getLifeLeft(), 50, 50);
    font.draw(display, playerTwo.getName() + ": " +
              playerTwo.getLifeLeft(), 650, 50);
    display.end();
  }

  public void showWinner() {
    display.begin();
    // magic lulz
    font.draw(display, this.winner + " gewinnt!", 350, 350);
    display.end();
  }

  /**
   * @return String winner
   */
  public String getWinner() {
    return this.winner;
  }

  /**
   * @return String loser
   */
  public String getLoser() {
    return this.loser;
  }

  /**
   * @return reference to playerOne
   */
  public PongPlayer getPlayerOne() {
    return this.playerOne;
  }

  /**
   * @return reference to playerTwo
   */
  public PongPlayer getPlayerTwo() {
    return this.playerTwo;
  }
}
