package io.muic.ooc.zorkArt.commands;

import io.muic.ooc.zorkArt.item.Player;
import io.muic.ooc.zorkArt.item.Portion;
import io.muic.ooc.zorkArt.item.Room;
import io.muic.ooc.zorkArt.item.Weapon;

/**
 * Created by ice on 2/2/17.
 */
public class takeCommand implements Command {
    @Override
    public void apply(Player player, String arg) {
        Room currentRoom = player.getCurrentRoom();

        try {
            Weapon weaponInRoom = currentRoom.getWeapon();
            Portion portionInRoom = currentRoom.getPortion();
            if (weaponInRoom != null && weaponInRoom.getName().equals(arg)) {
                System.out.println("Taking weapon " + arg);
                player.getWeapons().add(weaponInRoom);
                currentRoom.setWeapon(null);
            } else if (portionInRoom != null && portionInRoom.getName().equals(arg)) {
                System.out.println("Taking portion " + arg);
                player.getPortions().add(portionInRoom);
                currentRoom.setPortion(null);
            }

        } catch (Exception e) {
            System.out.println("No Weapon or portion in this room");
            e.printStackTrace();
        }
    }
}
