package io.muic.ooc.zorkArt.gameFactory;

import io.muic.ooc.zorkArt.commands.dropCommand;
import io.muic.ooc.zorkArt.commands.takeCommand;
import io.muic.ooc.zorkArt.item.Player;
import io.muic.ooc.zorkArt.item.Portion;
import io.muic.ooc.zorkArt.item.Weapon;
import io.muic.ooc.zorkArt.mapFactory.GameMap;
import io.muic.ooc.zorkArt.mapFactory.LevelOneFactory;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by ice on 2/3/17.
 */
public class GameFactoryTest {

    @Test
    public void dropCommandWeaponTest() throws Exception {
        System.out.println("Start testing dropCommandWeapon...");
        Player player = initializePlayer();
        dropCommand dropCommand = new dropCommand();

        int beforeDropWeapon = player.getWeapons().size();
        dropCommand.apply(player, "weapon1");
        int afterDropWeapon = player.getWeapons().size();
        assertTrue(beforeDropWeapon > afterDropWeapon);
        System.out.println("Drop weapon test passed");

    }

    @Test
    public void dropCommandPortionTest() throws Exception {
        System.out.println("Start testing dropCommandPortion...");
        Player player = initializePlayer();
        dropCommand dropCommand = new dropCommand();

        int beforeDropPortion = player.getPortions().size();
        dropCommand.apply(player, "Pportion1");
        int afterDropPortion = player.getPortions().size();
        assertTrue(beforeDropPortion > afterDropPortion);

        System.out.println("Drop portion test passed");
    }

    @Test
    public void takeCommandPlayerTest() throws Exception {
        System.out.println("Start testing takeCommandPlayer...");
        Player player = initializePlayer();
        takeCommand takeCommand = new takeCommand();

        int beforeTakeWeapon = player.getWeapons().size();
        takeCommand.apply(player, "weapon1");
        int afterTakeWeapon = player.getWeapons().size();

        assertTrue(beforeTakeWeapon < afterTakeWeapon);

        System.out.println("Test player taking weapon passed (Player side)");

    }

    @Test
    public void takeCommandRoomTest() throws Exception {
        System.out.println("Start testing takeCommandRoom...");
        Player player = initializePlayer();
        takeCommand takeCommand = new takeCommand();

        Weapon roomWeapon = player.getCurrentRoom().getWeapon();
        int beforeTakeWeaponRoom = 0;
        if (roomWeapon != null) {
            beforeTakeWeaponRoom = 1;
        }

        int afterTakeWeaponRoom = 1;
        if (roomWeapon == null) {
            afterTakeWeaponRoom = 0;
        }
        System.out.println(beforeTakeWeaponRoom);
        System.out.println(afterTakeWeaponRoom);
        assertTrue(beforeTakeWeaponRoom > afterTakeWeaponRoom);

        System.out.println("Test player taking weapon passed (Room side)");
    }

    public Player initializePlayer() throws Exception {
        Player player = new Player();

        TestMap testMap = new TestMap();
        testMap.create(player);

        return player;
    }

}