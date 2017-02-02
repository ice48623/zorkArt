package io.muic.ooc.zorkArt;

/**
 * Created by ice on 1/29/17.
 */
public class Room {
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private Monster monster;
    private Portion portion;
    private Items item;
    private Player player;

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Portion getPortion() {
        return portion;
    }

    public void setPortion(Portion portion) {
        this.portion = portion;
    }
}
