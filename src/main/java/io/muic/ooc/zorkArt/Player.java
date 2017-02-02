package io.muic.ooc.zorkArt;

import java.util.ArrayList;

/**
 * Created by ice on 1/29/17.
 */
public class Player {
    private String name;
    private double hp;
    private ArrayList<Weapon> weapons;
    private double attack;
    private ArrayList<Items> items;
    private ArrayList<Portion> portions;
    private Room currentRoom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public ArrayList<Portion> getPortions() {
        return portions;
    }

    public void setPortions(ArrayList<Portion> portions) {
        this.portions = portions;
    }
}
