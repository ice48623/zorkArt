package io.muic.ooc.zorkArt;


import java.util.ArrayList;

/**
 * Created by ice on 1/30/17.
 */
public interface MapFactory {

    ArrayList<Room> createRoom();
    ArrayList<Monster> createMonster();
    ArrayList<Weapon> createWeapon();
    ArrayList<Portion> createPortion();
    void connectRoom(ArrayList<Room> allRooms);
    void addMonster(ArrayList<Monster> allMonster, ArrayList<Room> allRooms);
    void addWeapon(ArrayList<Weapon> allWeapon, Player player);
    void addPortion(ArrayList<Portion> allPortions, ArrayList<Room> allRooms);
    GameMap create(Player player);

}
