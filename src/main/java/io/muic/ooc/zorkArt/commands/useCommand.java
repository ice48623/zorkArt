package io.muic.ooc.zorkArt.commands;

import io.muic.ooc.zorkArt.item.Player;
import io.muic.ooc.zorkArt.item.Portion;

/**
 * Created by ice on 2/2/17.
 */
public class useCommand implements Command {
    @Override
    public void apply(Player player, String arg) {
        double MAX_HP = 100;

        Portion usePortion;
        for (Portion portion : player.getPortions()) {
            if (portion.getName().equals(arg)) {
                usePortion = portion;

                double previousHp = player.getHp();
                player.setHp(previousHp + usePortion.getHealPower());
                if (player.getHp() > 100) {
                    player.setHp(100);
                }

                System.out.println("Use portion: " + usePortion.getName());
                System.out.println("Player HP: before: " + previousHp + " + " + usePortion.getHealPower() + " = " + player.getHp());

            }
        }
    }
}
