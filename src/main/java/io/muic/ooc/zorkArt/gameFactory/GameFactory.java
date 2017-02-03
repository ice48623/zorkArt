package io.muic.ooc.zorkArt.gameFactory;

import io.muic.ooc.zorkArt.item.Player;
import io.muic.ooc.zorkArt.commands.*;
import io.muic.ooc.zorkArt.mapFactory.GameMap;

import java.util.HashMap;

/**
 * Created by ice on 2/3/17.
 */
public abstract class GameFactory {
    private static final HashMap<String, Command> allCommand = new HashMap<String, Command>() {
        {
            // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
            put("info", new infoCommand());
            put("quit", new ExitCommand());
            put("go", new goCommand());
            put("attackWith", new attackWithCommand());
            put("use", new useCommand());
            put("take", new takeCommand());
            put("drop", new dropCommand());
            put("help", new helpCommand());

        }
    };

    public static Command getCommand(String name) {
        return allCommand.get(name);
    }

    public abstract void start(Player player);

    public abstract Boolean isOver(GameMap gameMap);
}
