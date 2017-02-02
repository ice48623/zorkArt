package io.muic.ooc.zorkArt;

/**
 * Created by ice on 1/29/17.
 */
public class Level extends GameMap {
    private static String level;

    public static String getLevel() {
        return level;
    }

    public static void setLevel(String level) {
        Level.level = level;
    }
}
