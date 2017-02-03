package io.muic.ooc.zorkArt.gameFactory;

import io.muic.ooc.zorkArt.item.*;
import io.muic.ooc.zorkArt.mapFactory.GameMap;
import io.muic.ooc.zorkArt.mapFactory.MapFactory;
import io.muic.ooc.zorkArt.mapFactory.readFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ice on 2/3/17.
 */
public class TestMap implements MapFactory{
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
        ComPro.setName("monster1");
        ComPro.setAttack(10);
        ComPro.setHp(40);
        ComPro.setLevel(1);
        ComPro.setAttackSuccessRate(0.3);

        Monster DataStruc = new Monster();
        DataStruc.setName("monster2");
        DataStruc.setLevel(2);
        DataStruc.setHp(60);
        DataStruc.setAttack(15);
        DataStruc.setAttackSuccessRate(0.2);

        Monster FilePro = new Monster();
        FilePro.setName("monster3");
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
        pencil.setName("Pweapon1");
        pencil.setAttackPower(20);
        pencil.setAttackSuccessRate(0.8);

        allWeapons.add(pencil);
        return allWeapons;

    }

    @Override
    public ArrayList<Portion> createPortion() {
        ArrayList<Portion> allPortions = new ArrayList<>();

        Portion portion1 = new Portion();
        portion1.setName("portion1");
        portion1.setHealPower(12);

        Portion portion2 = new Portion();
        portion2.setName("portion2");
        portion2.setHealPower(7);

        Portion portion3 = new Portion();
        portion3.setName("portion3");
        portion3.setHealPower(2);

        allPortions.add(portion1);
        allPortions.add(portion2);
        allPortions.add(portion3);

        return allPortions;
    }

    public ArrayList<Portion> createPlayerPortion(){
        ArrayList<Portion> allPortions = new ArrayList<>();

        Portion portion1 = new Portion();
        portion1.setName("Pportion1");
        portion1.setHealPower(12);

        Portion portion2 = new Portion();
        portion2.setName("Pportion2");
        portion2.setHealPower(7);

        Portion portion3 = new Portion();
        portion3.setName("Pportion3");
        portion3.setHealPower(2);

        allPortions.add(portion1);
        allPortions.add(portion2);
        allPortions.add(portion3);

        return allPortions;
    }

    public ArrayList<Weapon> createRoomWeapon(){
        ArrayList<Weapon> allWeapons = new ArrayList<>();
        Weapon weapon1 = new Weapon();
        weapon1.setName("weapon1");
        weapon1.setAttackPower(15);
        weapon1.setAttackSuccessRate(0.6);

        Weapon weapon2 = new Weapon();
        weapon2.setName("weapon2");
        weapon2.setAttackPower(40);
        weapon2.setAttackSuccessRate(0.2);

        Weapon weapon3 = new Weapon();
        weapon3.setName("weapon3");
        weapon3.setAttackPower(25);
        weapon3.setAttackSuccessRate(0.4);

        allWeapons.add(weapon1);
        allWeapons.add(weapon2);
        allWeapons.add(weapon3);
        return allWeapons;
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

    public void addWeaponToRoom(ArrayList<Weapon> allRoomWeapons, ArrayList<Room> allRooms) {
        int iterate = allRooms.size();
        if (allRoomWeapons.size() < iterate) {
            iterate = allRoomWeapons.size();
        }
        for (int i = 0; i < iterate; i++) {
            allRooms.get(i).setWeapon(allRoomWeapons.get(i));
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
        List<String> lines = readFile.readLine("/home/ice/Desktop/ooc/Assignment/a2/zorkArt/src/main/java/io/muic/ooc/zorkArt/mapConfigFiles/testmap.txt");
        int numberOfRoom = Integer.parseInt(lines.get(0));
        List<String> roomConfig = lines.subList(1, lines.size());


        GameMap gameMap = new GameMap();

        ArrayList<Room> allRoom = createRoom(numberOfRoom);
        ArrayList<Monster> allMonster = createMonster();
        ArrayList<Weapon> allWeapons = createWeapon();
        ArrayList<Weapon> allRoomWeapons = createRoomWeapon();
        ArrayList<Portion> allPortions = createPortion();
        ArrayList<Portion> allPlayerPortions = createPlayerPortion();

        connectRoom(allRoom, roomConfig);
        addMonster(allMonster, allRoom);
        addWeapon(allWeapons, player);
        addWeaponToRoom(allRoomWeapons, allRoom);
        addPortion(allPortions, allRoom);
        gameMap.setAllRooms(allRoom);

        player.setCurrentRoom(gameMap.getAllRooms().get(0));
//        ArrayList<Portion> playerPortion = new ArrayList<>();
        player.setPortions(allPlayerPortions);
        return gameMap;
    }
}
