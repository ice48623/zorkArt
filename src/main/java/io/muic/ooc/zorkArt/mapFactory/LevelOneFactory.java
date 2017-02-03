package io.muic.ooc.zorkArt.mapFactory;

import io.muic.ooc.zorkArt.item.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ice on 1/30/17.
 */
public class LevelOneFactory implements MapFactory {

    @Override
    public ArrayList<Room> createRoom(int numberOfRoom) {
        ArrayList<Room> allRooms = new ArrayList<>();
        for (int i = 0; i < numberOfRoom; i++) {
            allRooms.add(new Room());
        }
        return allRooms;
    }

    @Override
    public ArrayList<Monster> createMonster() {
        ArrayList<Monster> allMonster = new ArrayList<>();
        Monster ComPro = new Monster();
        ComPro.setName("Com pro 1");
        ComPro.setAttack(10);
        ComPro.setHp(40);
        ComPro.setLevel(1);
        ComPro.setAttackSuccessRate(0.3);

        Monster DataStruc = new Monster();
        DataStruc.setName("Data Structure");
        DataStruc.setLevel(2);
        DataStruc.setHp(60);
        DataStruc.setAttack(15);
        DataStruc.setAttackSuccessRate(0.2);

        Monster FilePro = new Monster();
        FilePro.setName("File Pro");
        FilePro.setLevel(2);
        FilePro.setHp(60);
        FilePro.setAttack(15);
        FilePro.setAttackSuccessRate(0.4);

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
    public void connectRoom(ArrayList<Room> allRooms, List<String> roomConfig) {
        for (String line : roomConfig) {
            ArrayList<Integer> allConfig = parseToInt(line);

            int w = allConfig.get(1);
            int n = allConfig.get(2);
            int e = allConfig.get(3);
            int s = allConfig.get(4);

            Room root = allRooms.get(allConfig.get(0));
            if (w != -1) {
                Room west = allRooms.get(w);
                root.setWest(west);
            }
            if (n != -1) {
                Room north = allRooms.get(n);
                root.setNorth(north);
            }
            if (e != -1) {
                Room east = allRooms.get(e);
                root.setEast(east);
            }
            if (s != -1) {
                Room south = allRooms.get(s);
                root.setSouth(south);
            }

        }
    }

    public ArrayList<Integer> parseToInt(String line) {
        ArrayList<Integer> allConfig = new ArrayList<>();
        String[] connectRoomConfig = line.split(" ");
        for (String con : connectRoomConfig) {
            allConfig.add(Integer.parseInt(con));
        }
        return allConfig;
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
        List<String> lines = readFile.readLine("./src/main/java/io/muic/ooc/zorkArt/mapConfigFiles/levelOneConfig.txt");
        int numberOfRoom = Integer.parseInt(lines.get(0));
        List<String> roomConfig = lines.subList(1, lines.size());


        GameMap gameMap = new GameMap();

        ArrayList<Room> allRoom = createRoom(numberOfRoom);
        ArrayList<Monster> allMonster = createMonster();
        ArrayList<Weapon> allWeapons = createWeapon();
        ArrayList<Portion> allPortions = createPortion();

        connectRoom(allRoom, roomConfig);
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
