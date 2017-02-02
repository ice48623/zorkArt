package io.muic.ooc.zorkArt;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ice on 1/31/17.
 */
public class Game {

    private static final HashMap<String, Command> allCommand = new HashMap<String, Command>() {
        {
            // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
            put("info", new infoCommand());
            put("quit", new ExitCommand());
            put("go", new goCommand());
            put("attackWith", new attackWithCommand());
            put("use", new useCommand());

        }
    };

    public static Command getCommand(String name) {
        return allCommand.get(name);
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        System.out.print("Enter player name: ");
        String name = scanner.nextLine();
        player.setName(name);
        player.setHp(80);
        player.setAttack(10);
        LevelOneFactory levelOne = new LevelOneFactory();
        levelOne.create(player);



        boolean quit = false;
        System.out.println("zork: Hello, command me!!");
        while (!quit) {
            System.out.print("You: ");
            String commandLine = scanner.nextLine();
            String[] args = commandLine.split(" ");
            Command command = Game.getCommand(args[0]);
            if (null == command) {
                System.out.println("Unknown command [" + commandLine + "]. Available commands: info and quit.");
            } else {
                if (args.length == 2) {
                    command.apply(player, args[1]);
                } else {
                    command.apply(player, null);
                }
            }
        }
    }
}
