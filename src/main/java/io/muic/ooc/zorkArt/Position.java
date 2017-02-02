package io.muic.ooc.zorkArt;

/**
 * Created by ice on 1/29/17.
 */
public class Position {
    private static int positionX;
    private static int positionY;

    public static int getPositionX() {
        return positionX;
    }

    public static void setPositionX(int positionX) {
        Position.positionX = positionX;
    }

    public static int getPositionY() {
        return positionY;
    }

    public static void setPositionY(int positionY) {
        Position.positionY = positionY;
    }
}
