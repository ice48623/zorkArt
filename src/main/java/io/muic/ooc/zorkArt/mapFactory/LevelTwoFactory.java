package io.muic.ooc.zorkArt.mapFactory;

import io.muic.ooc.zorkArt.item.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ice on 2/3/17.
 */
public class LevelTwoFactory implements MapFactory {
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
        List<String> lines = readFile.readLine("/home/ice/Desktop/ooc/Assignment/a2/zorkArt/src/main/java/io/muic/ooc/zorkArt/mapConfigFiles/levelOneConfig.txt");
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
