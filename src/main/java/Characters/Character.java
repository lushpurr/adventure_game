package Characters;

import Rooms.Room;
import Treasure.Treasure;

import java.util.ArrayList;

public abstract class Character {
    private String name;
    private int health;
    private int fear;
    private Room currentRoom;
    private ArrayList<Treasure> satchel;
    private boolean canBeAttacked;




    public Character(String name, int health, int fear, Room currentRoom){
        this.name = name;
        this.health = health;
        this.fear = fear;
        this.currentRoom = currentRoom;
        this.satchel = new ArrayList<Treasure>();
        this.canBeAttacked = true;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getFear() {
        return fear;
    }

    public void setFear(int fear) {
        this.fear = fear;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public ArrayList<Treasure> getSatchel() {
        return satchel;
    }

    public int satchelCount() {
        return satchel.size();
    }

    public boolean getCanBeAttacked() {
        return canBeAttacked;
    }

    public void setCanBeAttacked(boolean canBeAttacked) {
        this.canBeAttacked = canBeAttacked;
    }

    public void reduceHealth(int damage){
        this.health -= damage;
    }

    public void increaseHealth(int healing){
        this.health += healing;
    }


}
