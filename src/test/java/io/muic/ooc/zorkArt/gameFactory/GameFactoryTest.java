package io.muic.ooc.zorkArt.gameFactory;

import io.muic.ooc.zorkArt.commands.dropCommand;
import io.muic.ooc.zorkArt.commands.takeCommand;
import io.muic.ooc.zorkArt.commands.useCommand;
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
        dropCommand.apply(player, "Pweapon1");
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
    public void takeCommandWeaponPlayerTest() throws Exception {
        System.out.println("Start testing takeCommandWeaponPlayer...");
        Player player = initializePlayer();
        takeCommand takeCommand = new takeCommand();

        int beforeTakeWeapon = player.getWeapons().size();
        takeCommand.apply(player, "weapon1");
        int afterTakeWeapon = player.getWeapons().size();

        assertTrue(beforeTakeWeapon < afterTakeWeapon);

        System.out.println("Test player taking weapon passed (Player side)");

    }

    @Test
    public void takeCommandWeaponRoomTest() throws Exception {
        System.out.println("Start testing takeCommandWeaponRoom...");
        Player player = initializePlayer();
        takeCommand takeCommand = new takeCommand();

        Weapon beforeRoomWeapon = player.getCurrentRoom().getWeapon();
        int beforeTakeWeaponRoom = 0;
        if (beforeRoomWeapon != null) {
            beforeTakeWeaponRoom = 1;
        }

        takeCommand.apply(player, "weapon1");

        Weapon afterRoomWeapon = player.getCurrentRoom().getWeapon();
        int afterTakeWeaponRoom = 0;
        if (afterRoomWeapon != null) {
            afterTakeWeaponRoom = 1;
        }

        assertTrue(beforeTakeWeaponRoom > afterTakeWeaponRoom);

        System.out.println("Test player taking weapon passed (Room side)");
    }

    @Test
    public void takeCommandPortionRoomTest() throws Exception {
        System.out.println("Start testing takeCommandPortionRoom...");
        Player player = initializePlayer();
        takeCommand takeCommand = new takeCommand();

        Portion beforeRoomPortion = player.getCurrentRoom().getPortion();
        int beforeTakePortionRoom = 0;
        if (beforeRoomPortion != null) {
            beforeTakePortionRoom = 1;
        }

        takeCommand.apply(player, "portion1");

        Portion afterRoomPortion = player.getCurrentRoom().getPortion();
        int afterTakePortionRoom = 0;
        if (afterRoomPortion != null) {
            afterTakePortionRoom = 1;
        }

        assertTrue(beforeTakePortionRoom > afterTakePortionRoom);

        System.out.println("Test player taking portion passed (Room side)");
    }

    @Test
    public void useCommandPortion() throws Exception {
        System.out.println("Start testing useCommandPortion...");
        Player player = initializePlayer();
        useCommand useCommand = new useCommand();

        int beforeUsePortion = player.getPortions().size();
        useCommand.apply(player, "Pportion1");
        int afterUsePortion = player.getPortions().size();

        assertTrue(beforeUsePortion > afterUsePortion);

        System.out.println("Test player use portion passed");
    }

    public Player initializePlayer() throws Exception {
        Player player = new Player();
        TestMap testMap = new TestMap();
        testMap.create(player);

        return player;
    }

}