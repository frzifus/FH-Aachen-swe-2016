package swe.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import swe.game.Pong;

public class DesktopLauncher {
  public static void main(String[] arg) {
    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.title  = "SWE- Pong";
    config.width  = 800;
    config.height = 600;
    String p1 = "Default";
    String p2 = "testbot";
    if (arg.length >= 2) {
      p1 = arg[0];
      p2 = arg[1];
    }

    new LwjglApplication(new Pong(p1, p2), config);
  }

}
