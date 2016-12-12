package swe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input;

/**
 * @author Frzifus
 */

public class WelcomeScreen implements Screen {

  /**
   * hold reference to game
   */
  public Pong game;

  /**
   *
   */
  private SpriteBatch greetings;

  /**
   *
   */
  private BitmapFont font;

  /**
   *
   */
  private String greetingsMsg = "Space to enter!";

  /**
   *
   */
  private String userCtlInfoOne;

  /**
   *
   */
  private String userCtlInfoTwo;

  /**
   *
   */
  public CtlInputProcessor ctlInputProcessor;

  /**
   *
   */
  public ScoreBoard scoreBoard;

  /**
   *
   */
  public PongPlayer playerOne;

  /**
   *
   */
  public PongPlayer playerTwo;

  /**
   *
   */
  public PongSphere pongDemoSphere;

  /**
   *  Constructor
   * @param reference of game
   *                  create two new players and hold a reference of game
   */
  WelcomeScreen(Pong game, ScoreBoard scoreBoard) {
    this.game = game;
    greetings = new SpriteBatch();
    font = new BitmapFont();
    font.setColor(0.5f,0.4f,0,1);
    ctlInputProcessor = new CtlInputProcessor(game);
    this.scoreBoard = scoreBoard;
    this.playerOne = scoreBoard.getPlayerOne();
    this.playerTwo = scoreBoard.getPlayerTwo();
    this.userCtlInfoOne = playerOne.getName() + "\nMove up: W \nMove down: S";
    this.userCtlInfoTwo = playerTwo.getName() + "\nMove up: Up \nMove down: Down";
    Gdx.input.setInputProcessor(ctlInputProcessor);
    this.pongDemoSphere = new PongSphere();
    System.out.println("hallo \uf02d");
  }

  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(0, 0, 0, 0);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    greetings.begin();
    font.draw(greetings, userCtlInfoOne,playerOne.getX(),
    		 2 * playerOne.getHeight() + playerOne.getY());
    font.draw(greetings, userCtlInfoTwo,playerTwo.getX() - 100,
   		 2 * playerTwo.getHeight() + playerTwo.getY());
    font.draw(greetings, greetingsMsg, 350, 180);
    greetings.end();

    pongDemoSphere.toggleHold();
    pongDemoSphere.render();
    playerOne.render();
    playerTwo.render();

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
    // never called automatically
  }

}
