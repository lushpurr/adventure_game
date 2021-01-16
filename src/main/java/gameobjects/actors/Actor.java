package gameobjects.actors;

import gameobjects.ThingHolder;
import gameobjects.ThingList;
import gameobjects.rooms.Room;

public class Actor extends ThingHolder {
    private Room location;// current room where the person is
    private int hp;
    private int fightPoints;

    public Actor(String name, String description, ThingList tl, Room room, int hp, int fightPoints){
        super(name, description, tl);
        this.location = room;
        this.hp = hp;
        this.fightPoints = fightPoints;
    }

    public Actor(String name, String description, boolean canTake, boolean canFight, boolean canEat, boolean canDrink, ThingList tl, Room room, int hp, int fightPoints){
        super(name, description, canTake, canFight, canEat, canDrink, tl);
        this.location = room;
        this.hp = hp;
        this.fightPoints = fightPoints;

    }


    public Room getLocation() {
        return location;
    }

    public void setLocation(Room location) {
        this.location = location;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void reduceHp(int damage){
        this.hp -= damage;
    }

    public int getFightPoints() {
        return fightPoints;
    }
}
