package io.muic.ooc.zorkArt.gameFactory;

import io.muic.ooc.zorkArt.item.Monster;
import io.muic.ooc.zorkArt.item.Player;
import io.muic.ooc.zorkArt.item.Room;
import io.muic.ooc.zorkArt.commands.Command;
import io.muic.ooc.zorkArt.mapFactory.GameMap;
import io.muic.ooc.zorkArt.mapFactory.LevelOneFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by ice on 1/31/17.
 */
public class LevelOneGame extends GameFactory {

        @Override
        public void start(Player player) {
        // LEVEL ONE
        Scanner scanner = new Scanner(System.in);
        LevelOneFactory levelOne = new LevelOneFactory();
        GameMap gameMap = levelOne.create(player);

        boolean levelOneOver = false;
        System.out.println("zork: Hello, command me!!");
        while (!levelOneOver) {
            System.out.print("You: ");
            String commandLine = scanner.nextLine();
            String[] args = commandLine.split(" ");
            Command command = LevelOneGame.getCommand(args[0]);
            if (null == command) {
                System.out.println("Unknown command [" + commandLine + "]. Available commands: info and quit.");

            } else {
                if (args.length == 2) {
                    command.apply(player, args[1]);
                } else {
                    command.apply(player, null);
                }
            }

            if (isOver(gameMap)) {
                levelOneOver = true;
                System.out.println("Finish level one!!!");
            }
            System.out.println();
        }

    }

    @Override
    public Boolean isOver(GameMap gameMap) {
        ArrayList<Room> allRooms = gameMap.getAllRooms();
        Iterator<Room> iterator = allRooms.iterator();
        while (iterator.hasNext()) {
            Room room = iterator.next();
            if (hasMonster(room)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean hasMonster(Room room) {
        Monster monster = room.getMonster();
        if (monster == null) {
            return false;
        }
        return true;
    }
}
