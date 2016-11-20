package swe.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import swe.game.Pong;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new Pong(), config);


        Gson gson = new Gson();
        JsonObject jso = new JsonObject();
        // in dem arg[] sind die namen der spieler enthalten
        if (arg.length >= 2) {
            jso.addProperty("winner", arg[0]);
            jso.addProperty("loser", arg[1]);
            String json = gson.toJson(jso);
            System.out.println(json);
        }
        // TODO: Handhabung falls keine Spielernamen übergeben


    }
}
