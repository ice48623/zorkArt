package io.muic.ooc.zorkArt.mapFactory;


import io.muic.ooc.zorkArt.item.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ice on 1/30/17.
 */
public interface MapFactory {

    ArrayList<Room> createRoom(int NumberOfRoom);
    ArrayList<Monster> createMonster();
    ArrayList<Weapon> createWeapon();
    ArrayList<Portion> createPortion();
    void connectRoom(ArrayList<Room> allRooms, List<String> roomConfig);
    void addMonster(ArrayList<Monster> allMonster, ArrayList<Room> allRooms);
    void addWeapon(ArrayList<Weapon> allWeapon, Player player);
    void addPortion(ArrayList<Portion> allPortions, ArrayList<Room> allRooms);
    GameMap create(Player player);

}
