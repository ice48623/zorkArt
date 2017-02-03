package io.muic.ooc.zorkArt.commands;

import io.muic.ooc.zorkArt.item.Player;
import io.muic.ooc.zorkArt.item.Portion;

import java.util.Iterator;

/**
 * Created by ice on 2/2/17.
 */
public class useCommand implements Command {
    @Override
    public void apply(Player player, String arg) {
        double MAX_HP = 100;

        Iterator<Portion> iterator = player.getPortions().iterator();
        while (iterator.hasNext()) {
            Portion portion = iterator.next();
            if (portion.getName().equals(arg)) {
                Portion usePortion = portion;
                double previousHp = player.getHp();
                player.setHp(previousHp + usePortion.getHealPower());
                if (player.getHp() > MAX_HP) {
                    player.setHp(100);
                }

                iterator.remove();

                System.out.println("Use portion: " + usePortion.getName());
                System.out.println("Player HP: before: " + previousHp + " + " + usePortion.getHealPower() + " = " + player.getHp());
            }
        }
    }
}
