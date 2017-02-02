package io.muic.ooc.zorkArt;

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
                System.out.println("north: " + nextRoom);
                if (nextRoom != null) {
                    player.setCurrentRoom(nextRoom);
                } else {
                    System.out.println("No way to north");
                }
                break;
            case "south":
                nextRoom = player.getCurrentRoom().getSouth();
                System.out.println("south: " + nextRoom);
                if (nextRoom != null) {
                    player.setCurrentRoom(nextRoom);
                } else {
                    System.out.println("No way to south");
                }

                break;
            case "east":
                nextRoom = player.getCurrentRoom().getEast();
                System.out.println("east: " + nextRoom);
                if (nextRoom != null) {
                    player.setCurrentRoom(nextRoom);
                } else {
                    System.out.println("No way to east");
                }

                break;
            case "west":
                nextRoom = player.getCurrentRoom().getWest();
                System.out.println("west: " + nextRoom);
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
