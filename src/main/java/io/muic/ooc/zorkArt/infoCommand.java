package io.muic.ooc.zorkArt;

/**
 * Created by ice on 1/31/17.
 */
public class infoCommand implements Command {
    @Override
    public void apply(Player player, String arg) {
        Room currentRoom = player.getCurrentRoom();

        try {
            System.out.println("Player Information: ");
            System.out.println("Name: " + player.getName());
            System.out.println("HP: " + player.getHp());
            System.out.println("Attack Power: " + player.getAttack());
        } catch (Exception e) {
            System.out.println("Error getting player information");
        }

        System.out.println("----------------------------------");

        System.out.println("All weapons in bag: ");
        try {
            for (Weapon weapon : player.getWeapons()) {
                System.out.println("Name: " + weapon.getName());
                System.out.println("Attack Power: " + weapon.getAttackPower());
                System.out.println("Attack Success Rate: " + weapon.getAttackSuccessRate());
            }
        } catch (Exception we) {
            System.out.println("No weapon in bag");
        }

        System.out.println("----------------------------------");

        System.out.println("All portions in bag: ");
        try {
            for (Portion portion : player.getPortions()) {
                System.out.println("Name: " + portion.getName());
                System.out.println("Heal Power: " + portion.getHealPower());
            }
        } catch (Exception pe) {
            System.out.println("No portion in bag");
        }

        System.out.println("----------------------------------");

        System.out.println("Room Information: ");
        try {
            Monster currentMonster = currentRoom.getMonster();
            System.out.println("Monster in this room:");
            System.out.println("Name: " + currentMonster.getName());
            System.out.println("HP: " + currentMonster.getHp());
            System.out.println("Attack Power: " + currentMonster.getAttack());
        } catch (Exception e) {
            System.out.println("No monster in this room");
        }

        System.out.println("----------------------------------");

        try {
            Portion portionInRoom = currentRoom.getPortion();
            System.out.println("Portion in this room: ");
            System.out.println("Name: " + portionInRoom.getName());
            System.out.println("Heal Power: " + portionInRoom.getHealPower());
        } catch (Exception e) {
            System.out.println("No portion in this room");
//            e.printStackTrace();
        }

        System.out.println("----------------------------------");

    }
}
