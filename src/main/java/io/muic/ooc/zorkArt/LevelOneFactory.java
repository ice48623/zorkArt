package io.muic.ooc.zorkArt;

import java.util.ArrayList;
import java.util.WeakHashMap;

/**
 * Created by ice on 1/30/17.
 */
public class LevelOneFactory implements MapFactory {

    @Override
    public ArrayList<Room> createRoom() {
        ArrayList<Room> allRooms = new ArrayList<>();
        allRooms.add(new Room());
        allRooms.add(new Room());
        allRooms.add(new Room());
        return allRooms;
    }

    @Override
    public ArrayList<Items> createItem() {
        ArrayList<Items> allItems = new ArrayList<>();
        allItems.add(new Items());
        allItems.add(new Items());
        allItems.add(new Items());
        return allItems;
    }

    @Override
    public ArrayList<Monster> createMonster() {
        ArrayList<Monster> allMonster = new ArrayList<>();
        Monster ComPro = new Monster();
        ComPro.setName("Computer Programming Monster");
        ComPro.setAttack(10);
        ComPro.setHp(100);
        ComPro.setLevel(1);

        Monster DataStruc = new Monster();
        DataStruc.setName("Data Structure Monster");
        DataStruc.setLevel(2);
        DataStruc.setHp(100);
        DataStruc.setAttack(15);

        Monster FilePro = new Monster();
        FilePro.setName("File Processing Monster");
        FilePro.setLevel(2);
        FilePro.setHp(100);
        FilePro.setAttack(15);

        allMonster.add(ComPro);
        allMonster.add(DataStruc);
        allMonster.add(FilePro);
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
        Mocha.setName("Mocha");
        Mocha.setHealPower(12);

        Portion Coke = new Portion();
        Coke.setName("Coke");
        Coke.setHealPower(7);

        Portion Candy = new Portion();
        Candy.setName("Candy");
        Candy.setHealPower(2);

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
    public void addItems() {

    }

    @Override
    public void addWeapon(ArrayList<Weapon> allWeapons, Player player) {
        player.setWeapons(allWeapons);
    }

    @Override
    public void addMonster(ArrayList<Monster> allMonster, ArrayList<Room> allRooms) {
        int iterate = allRooms.size();
        if (allMonster.size() < iterate) {
            iterate = allMonster.size();
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
        ArrayList<Items> allItems = createItem();
        ArrayList<Monster> allMonster = createMonster();
        ArrayList<Weapon> allWeapons = createWeapon();
        ArrayList<Portion> allPortions = createPortion();

        connectRoom(allRoom);
        addMonster(allMonster, allRoom);
        addWeapon(allWeapons, player);
        addPortion(allPortions, allRoom);
        gameMap.setAllRooms(allRoom);

        player.setCurrentRoom(gameMap.allRooms.get(0));
        return gameMap;
    }
}
