package io.muic.ooc.zorkArt.mapFactory;

import io.muic.ooc.zorkArt.item.*;

import java.util.ArrayList;

/**
 * Created by ice on 2/3/17.
 */
public class LevelTwoFactory implements MapFactory {
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
        Monster ComPro2 = new Monster();
        ComPro2.setName("Com Pro 2");
        ComPro2.setAttack(10);
        ComPro2.setHp(40);
        ComPro2.setLevel(1);
        ComPro2.setAttackSuccessRate(0.15);

        Monster DataComm = new Monster();
        DataComm.setName("Data Comm");
        DataComm.setLevel(2);
        DataComm.setHp(60);
        DataComm.setAttack(15);
        DataComm.setAttackSuccessRate(0.2);

        Monster SAD = new Monster();
        SAD.setName("SAD");
        SAD.setLevel(2);
        SAD.setHp(60);
        SAD.setAttack(15);
        SAD.setAttackSuccessRate(0.3);

        allMonster.add(ComPro2);
        allMonster.add(DataComm);
        allMonster.add(SAD);
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
        Mocha.setName("Latte");
        Mocha.setHealPower(16);

        Portion Coke = new Portion();
        Coke.setName("Coke Zero");
        Coke.setHealPower(7);

        Portion Candy = new Portion();
        Candy.setName("Oishi");
        Candy.setHealPower(5);

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
