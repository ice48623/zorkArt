package io.muic.ooc.zorkArt;

/**
 * Created by ice on 1/29/17.
 */
public class Monster {
    private static String name;
    private static double hp;
    private static double attack;
    private static int level;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Monster.name = name;
    }

    public static double getHp() {
        return hp;
    }

    public static void setHp(double hp) {
        Monster.hp = hp;
    }

    public static double getAttack() {
        return attack;
    }

    public static void setAttack(double attack) {
        Monster.attack = attack;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        Monster.level = level;
    }
}
