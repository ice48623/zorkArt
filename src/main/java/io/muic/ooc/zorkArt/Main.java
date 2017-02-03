package io.muic.ooc.zorkArt;

import io.muic.ooc.zorkArt.gameFactory.LevelOneGame;
import io.muic.ooc.zorkArt.gameFactory.LevelThreeGame;
import io.muic.ooc.zorkArt.gameFactory.LevelTwoGame;
import io.muic.ooc.zorkArt.item.Player;

import java.util.Scanner;

/**
 * Created by ice on 1/25/17.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        System.out.print("Enter player name: ");
        String name = scanner.nextLine();
        player.setName(name);
        player.setHp(80);
        player.setAttack(10);

        LevelOneGame levelOneGame = new LevelOneGame();
        levelOneGame.start(player);

        LevelTwoGame levelTwoGame = new LevelTwoGame();
        levelTwoGame.start(player);

        LevelThreeGame levelThreeGame = new LevelThreeGame();
        levelThreeGame.start(player);
    }

}
