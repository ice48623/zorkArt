package io.muic.ooc.zorkArt.mapFactory;

import io.muic.ooc.zorkArt.item.*;

import java.util.ArrayList;

/**
 * Created by ice on 2/3/17.
 */
public class LevelThreeFactory implements MapFactory {
    @Override
    public ArrayList<Room> createRoom() {
        ArrayList<Room> allRooms = new ArrayList<>();
        allRooms.add(new Room());
        allRooms.add(new Room());
        allRooms.add(new Room());
        return allRooms;
    }

    @Override
    public ArrayList<Monster> createMonster() {
        ArrayList<Monster> allMonster = new ArrayList<>();
        Monster OPL = new Monster();
        OPL.setName("OPL");
        OPL.setAttack(19);
        OPL.setHp(75);
        OPL.setLevel(4);
        OPL.setAttackSuccessRate(0.1);

        Monster Algo = new Monster();
        Algo.setName("Algo");
        Algo.setLevel(4);
        Algo.setHp(70);
        Algo.setAttack(17);
        Algo.setAttackSuccessRate(0.2);


        Monster OOC = new Monster();
        OOC.setName("OS");
        OOC.setLevel(5);
        OOC.setHp(80);
        OOC.setAttack(20);
        OOC.setAttackSuccessRate(0.4);

        allMonster.add(OPL);
        allMonster.add(Algo);
        allMonster.add(OOC);
        return allMonster;
    }

    @Override
    public ArrayList<Weapon> createWeapon() {
        ArrayList<Weapon> allWeapons = new ArrayList<>();
        Weapon pencil = new Weapon();
        pencil.setName("pencil");
        pencil.setAttackPower(20);
        pencil.setAttackSuccessRate(0.8);

        allWeapons.add(pencil);
        return allWeapons;

    }

    @Override
    public ArrayList<Portion> createPortion() {
        ArrayList<Portion> allPortions = new ArrayList<>();

        Portion Mocha = new Portion();
        Mocha.setName("Americano");
        Mocha.setHealPower(20);

        Portion Coke = new Portion();
        Coke.setName("Sleep");
        Coke.setHealPower(30);

        Portion Candy = new Portion();
        Candy.setName("Fruit");
        Candy.setHealPower(6);

        allPortions.add(Mocha);
        allPortions.add(Coke);
        allPortions.add(Candy);

        return allPortions;
    }

    @Override
    public void connectRoom(ArrayList<Room> allRooms) {

        for (int i = 0; i < allRooms.size() -1; i++) {
            allRooms.get(i).setEast(allRooms.get(i + 1));
            allRooms.get(i + 1).setWest(allRooms.get(i));
        }
    }


    @Override
    public void addWeapon(ArrayList<Weapon> allWeapons, Player player) {
        player.setWeapons(allWeapons);
    }

    @Override
    public void addMonster(ArrayList<Monster> allMonster, ArrayList<Room> allRooms) {
        int iterate = allMonster.size();
        if (allRooms.size() < iterate) {
            iterate = allRooms.size();
        }

        for (int i = 0; i < iterate; i++) {
            allRooms.get(i).setMonster(allMonster.get(i));
        }

    }

    @Override
    public void addPortion(ArrayList<Portion> allPortions, ArrayList<Room> allRooms) {
        int iterator = allPortions.size();
        if (allRooms.size() < iterator) {
            iterator = allRooms.size();
        }

        for (int i = 0; i < iterator; i++) {
            allRooms.get(i).setPortion(allPortions.get(i));
        }
    }

    @Override
    public GameMap create(Player player) {
        GameMap gameMap = new GameMap();

        ArrayList<Room> allRoom = createRoom();
        ArrayList<Monster> allMonster = createMonster();
        ArrayList<Weapon> allWeapons = createWeapon();
        ArrayList<Portion> allPortions = createPortion();

        connectRoom(allRoom);
        addMonster(allMonster, allRoom);
        addWeapon(allWeapons, player);
        addPortion(allPortions, allRoom);
        gameMap.setAllRooms(allRoom);

        player.setCurrentRoom(gameMap.allRooms.get(0));
        ArrayList<Portion> playerPortion = new ArrayList<>();
        player.setPortions(playerPortion);
        return gameMap;
    }
}
