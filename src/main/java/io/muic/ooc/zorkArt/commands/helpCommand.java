package io.muic.ooc.zorkArt.commands;

import io.muic.ooc.zorkArt.item.Player;

/**
 * Created by ice on 2/4/17.
 */
public class helpCommand implements Command {
    @Override
    public void apply(Player player, String arg) {
        String help = "Commands:\n" +
                "info - print all current information of a player, including the current room that character is at.\n" +
                "go <DIRECTION> - move character to specific DIRECTION.\n" +
                "attackWith <WEAPON> - attack a monster in current room with specified WEAPON. WEAPON will not be destroy\n" +
                "                      or decrease ability after use.\n" +
                "use <PORTION> - use specified PORTION to increase character HP and/or ability. PORTION will get\n" +
                "                destroy after used.\n" +
                "take <ITEM> - take specified ITEM into character bag. This ITEM will disappear from the current room\n" +
                "              if it is taken. ITEM can be either weapon or portion.\n" +
                "drop <ITEM> - drop specified ITEM from character bag. This ITEM will be destroyed if it is dropped.\n" +
                "              ITEM can be either weapon or portion.\n" +
                "help - print all available commands and its usage.\n" +
                "quit - quit the levelOneGame.";
        System.out.println(help);
    }
}
