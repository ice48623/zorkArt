package io.muic.ooc.zorkArt.commands;

import io.muic.ooc.zorkArt.item.Player;
import io.muic.ooc.zorkArt.item.Room;

/**
 * Created by ice on 2/1/17.
 */
public class goCommand implements Command{
    @Override
    public void apply(Player player, String arg) {
//        System.out.println("go " + arg);

        Room nextRoom;
        switch (arg) {
            case "north":

                nextRoom = player.getCurrentRoom().getNorth();

                if (nextRoom != null) {
                    player.setCurrentRoom(nextRoom);
                } else {
                    System.out.println("No way to north");
                }
                break;
            case "south":
                nextRoom = player.getCurrentRoom().getSouth();

                if (nextRoom != null) {
                    player.setCurrentRoom(nextRoom);
                } else {
                    System.out.println("No way to south");
                }

                break;
            case "east":
                nextRoom = player.getCurrentRoom().getEast();

                if (nextRoom != null) {
                    player.setCurrentRoom(nextRoom);
                } else {
                    System.out.println("No way to east");
                }

                break;
            case "west":
                nextRoom = player.getCurrentRoom().getWest();

                if (nextRoom != null) {
                    player.setCurrentRoom(nextRoom);
                } else {
                    System.out.println("No way to west");
                }

                break;
            default:
                System.out.println("No Direction");
                break;

        }
    }

}
