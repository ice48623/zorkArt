package io.muic.ooc.zorkArt;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by ice on 2/1/17.
 */
public class attackWithCommand implements Command {
    @Override
    public void apply(Player player, String arg) {
        Weapon useWeapon = null;
        for (Weapon weapon : player.getWeapons()) {
            if (weapon.getName().equals(arg)) {
                useWeapon = weapon;
            }
        }

        if (useWeapon == null) {
            System.out.println("No specified weapon in bag");
        } else {
            Room currentRoom = player.getCurrentRoom();
            Monster monster = currentRoom.getMonster();
            if (monster != null) {
                monster.setHp(monster.getHp() - useWeapon.getAttackPower());
                if (monster.getHp() <= 0) {
                    System.out.println(monster.getName() + " is dead");
                    currentRoom.setMonster(null);
                } else {
                    double random = ThreadLocalRandom.current().nextDouble(monster.getMIN_SUCCESS_RATE(), monster.getMAX_SUCCESS_RATE());
                    System.out.println(random);
                    if (random <= monster.getAttackSuccessRate()) {
                        double currentHP = player.getHp();
                        player.setHp(currentHP - monster.getAttack());
                        System.out.println(monster.getName() + " attack!! " + "( " + monster.getAttack() + " )");
                        if (player.getHp() > 0) {
                            System.out.println(player.getName() + " HP = " + player.getHp());
                        } else {
                            System.out.println("You got kill by " + monster.getName());
                            System.out.println("GAME OVER!!!");
                            System.exit(0);
                        }

                    }
                    System.out.println(monster.getName() + " HP: " + monster.getHp());
                }

            } else {
                System.out.println("Could not attack. No monster in this room");
            }
        }


    }
}
