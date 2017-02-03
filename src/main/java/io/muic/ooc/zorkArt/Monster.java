package io.muic.ooc.zorkArt;

/**
 * Created by ice on 1/29/17.
 */
public class Monster {
    private String name;
    private double hp;
    private double attack;
    private int level;
    private double attackSuccessRate;
    private double MAX_SUCCESS_RATE = 0.6;
    private double MIN_SUCCESS_RATE = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getAttackSuccessRate() {
        return attackSuccessRate;
    }

    public void setAttackSuccessRate(double attackSuccessRate) {
        this.attackSuccessRate = attackSuccessRate;
    }

    public double getMAX_SUCCESS_RATE() {
        return MAX_SUCCESS_RATE;
    }

    public void setMAX_SUCCESS_RATE(double MAX_SUCCESS_RATE) {
        this.MAX_SUCCESS_RATE = MAX_SUCCESS_RATE;
    }

    public double getMIN_SUCCESS_RATE() {
        return MIN_SUCCESS_RATE;
    }

    public void setMIN_SUCCESS_RATE(double MIN_SUCCESS_RATE) {
        this.MIN_SUCCESS_RATE = MIN_SUCCESS_RATE;
    }
}
