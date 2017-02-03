package io.muic.ooc.zorkArt.gameFactory;

import io.muic.ooc.zorkArt.item.Monster;
import io.muic.ooc.zorkArt.item.Player;
import io.muic.ooc.zorkArt.item.Room;
import io.muic.ooc.zorkArt.commands.Command;
import io.muic.ooc.zorkArt.mapFactory.GameMap;
import io.muic.ooc.zorkArt.mapFactory.LevelThreeFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by ice on 2/3/17.
 */
public class LevelThreeGame extends GameFactory {
    @Override
    public void start(Player player) {
        // LEVEL THREE
        System.out.println("Welcome to level three");
        Scanner scanner = new Scanner(System.in);
        LevelThreeFactory levelThree = new LevelThreeFactory();
        GameMap gameMap = levelThree.create(player);

        boolean levelTwoOver = false;
        while (!levelTwoOver) {
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
                levelTwoOver = true;
                System.out.println("Finish level three !!!");
                System.out.println("The game is over !!!");
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
