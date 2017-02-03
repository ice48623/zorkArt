package io.muic.ooc.zorkArt.mapFactory;

import io.muic.ooc.zorkArt.item.Room;

import java.util.ArrayList;

/**
 * Created by ice on 1/29/17.
 */
public class GameMap {
    ArrayList<Room> allRooms;


    public ArrayList<Room> getAllRooms() {
        return allRooms;
    }

    public void setAllRooms(ArrayList<Room> allRooms) {
        this.allRooms = allRooms;
    }

}
