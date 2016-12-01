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
    new LwjglApplication(new Pong(), config);

    Gson gson = new Gson();
    JsonObject jso = new JsonObject();

    if (arg.length >= 2) {
      jso.addProperty("winner", arg[0]);
      jso.addProperty("loser", arg[1]);
      String json = gson.toJson(jso);
      System.out.println(json);
    }
  }

  public void Render() {

  }
}
