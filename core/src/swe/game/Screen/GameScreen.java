package swe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Input.Keys;

/**
 * @author Frzifus
 */

public class GameScreen implements Screen {

  /**
   * static const gameSpeed
   */
  private static final int gameSpeed = 10;

  /**
   * reference to playerOne
   */
  private PongPlayer playerOne;

  /**
   * reference to playerTwo
   */
  private PongPlayer playerTwo;

  /**
   * hold reference to game
   */
  public Pong game;

  /**
   * hold reference to scoreBoard
   */
  public ScoreBoard scoreBoard;


  /**
   * hold reference to pongSphere
   */
  public PongSphere pongSphere;

  /**
   * hold reference to collision
   */
  public Collision collision;

  /**
   * hold reference to playingField
   */
  public PlayingField playingField;

  /**
   *
   */
  public CtlInputProcessor ctlInputProcessor;

  /**
   *  Constructor
   * @param reference of game
   *                  create two new players and hold a reference of game
   */
  GameScreen(Pong game, ScoreBoard scoreBoard) {
    this.game = game;
    this.scoreBoard = scoreBoard;
    this.pongSphere = new PongSphere();
    this.playerOne = scoreBoard.getPlayerOne();
    this.playerTwo = scoreBoard.getPlayerTwo();
    this.playingField = new PlayingField(700,500);
    this.collision = new Collision(playerOne, playerTwo, pongSphere,
                                   playingField);

    this.playerOne.setStartPosition(playingField.getX() + 10 ,
                                    260);
    this.playerTwo.setStartPosition(playingField.getX()
                                    + playingField.getWidth()
                                    - playerTwo.getWidth() - 10,
                                    260);
    playerOne.setInputKeys(Keys.W, Keys.S);
    ctlInputProcessor = new CtlInputProcessor(game);
    Gdx.input.setInputProcessor(ctlInputProcessor);
  }

  @Override
  public void render(float delta) {
    this.playerOne.checkInput(gameSpeed);
    this.playerTwo.checkInput(gameSpeed);

    Gdx.gl.glClearColor(1, 1, 0, 0);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    playingField.render();
    collision.Check();
    scoreBoard.showScore();

    if (this.scoreBoard.CheckSomeoneDie()) {
      game.setScreen(game.endScreen);
    }

    this.pongSphere.render();
    this.playerOne.render();
    this.playerTwo.render();
  }

  @Override
  public void resize(int width, int height) {}

  @Override
  public void show() {
    // called when this screen is set as the screen with game.setScreen();
  }

  @Override
  public void hide() {
    // called when current screen changes from this to a different screen
  }

  @Override
  public void pause() {}

  @Override
  public void resume() {}

  @Override
  public void dispose() {
  }

}
