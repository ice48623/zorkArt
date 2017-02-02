package io.muic.ooc.zorkArt;

/**
 * Created by ice on 2/1/17.
 */
public class Weapon extends Items {
    private double attackPower;
    private double attackSuccessRate;

    public double getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }

    public double getAttackSuccessRate() {
        return attackSuccessRate;
    }

    public void setAttackSuccessRate(double attackSuccessRate) {
        this.attackSuccessRate = attackSuccessRate;
    }
}
