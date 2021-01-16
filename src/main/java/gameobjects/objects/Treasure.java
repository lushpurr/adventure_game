package gameobjects.objects;

import gameobjects.Thing;

public class Treasure extends Thing {

    private int value;

    public Treasure(String name, String description, boolean canTake, boolean canFight, boolean canEat, boolean canDrink, int value){
        super(name, description, canTake, canFight, canEat, canDrink);
        this.value = value;
    }
}
