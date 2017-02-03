package io.muic.ooc.zorkArt.commands;

import io.muic.ooc.zorkArt.item.Player;
import io.muic.ooc.zorkArt.item.Portion;
import io.muic.ooc.zorkArt.item.Weapon;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ice on 2/2/17.
 */
public class dropCommand implements Command {
    @Override
    public void apply(Player player, String arg) {
        ArrayList<Weapon> playerWeapons = player.getWeapons();
        ArrayList<Portion> playerPortions = player.getPortions();

        try {
            Iterator<Weapon> weaponIterator = playerWeapons.iterator();
            while (weaponIterator.hasNext()) {
                Weapon weapon = weaponIterator.next();
                if (weapon.getName().equals(arg)) {
                    weaponIterator.remove();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Not found specified item in weapon");
        }

        try {
            Iterator<Portion> portionIterator = playerPortions.iterator();
            while (portionIterator.hasNext()) {
                Portion portion = portionIterator.next();
                if (portion.getName().equals(arg)) {
                    portionIterator.remove();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Not found specified item in portion");
        }
    }
}
