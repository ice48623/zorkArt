package io.muic.ooc.zorkArt;

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
                if (monster.getHp() == 0) {
                    System.out.println("Monster: " + monster.getName() + " is dead");
                    currentRoom.setMonster(null);
                } else {
                    System.out.println("Monster HP: " + monster.getHp());
                }

            } else {
                System.out.println("Could not attack. No monster in this room");
            }
        }


    }
}
