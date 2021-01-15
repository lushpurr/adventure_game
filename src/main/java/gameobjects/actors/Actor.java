package gameobjects.actors;

import gameobjects.ThingHolder;
import gameobjects.ThingList;
import gameobjects.rooms.Room;

public class Actor extends ThingHolder {
    private Room location; // current room where the person is

    public Actor(String name, String description, ThingList tl, Room room){
        super(name, description, tl);
        this.location = room;
    }

    public Room getLocation() {
        return location;
    }

    public void setLocation(Room location) {
        this.location = location;
    }
}
