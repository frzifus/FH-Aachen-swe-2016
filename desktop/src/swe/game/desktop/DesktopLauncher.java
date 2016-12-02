package swe.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import swe.game.Pong;

public class DesktopLauncher {
  public static void main(String[] arg) {
    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.title  = "Pong";
    config.width  = 800;
    config.height = 600;
    String p1 = "default1";
    String p2 = "default2";
    if (arg.length >= 2) {
      p1 = arg[0];
      p2 = arg[1];
    }
    new LwjglApplication(new Pong(p1, p2), config);

    Gson gson = new Gson();
    JsonObject jso = new JsonObject();

    jso.addProperty("winner", Pong.winner);
    jso.addProperty("loser", Pong.loser);
    String json = gson.toJson(jso);
    System.out.println(json);
  }

  public void Render() {

  }
}
