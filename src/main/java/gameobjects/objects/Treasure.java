package gameobjects.objects;

import gameobjects.Thing;

public class Treasure extends Thing {

    private int value;

    public Treasure(String name, String description, int value){
        super(name, description);
        this.value = value;
    }
}
