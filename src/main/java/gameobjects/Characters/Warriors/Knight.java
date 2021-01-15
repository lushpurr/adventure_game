package gameobjects.Characters.Warriors;

import gameobjects.Characters.Character;
import gameobjects.Rooms.Room;

public class Knight extends Warrior {
    public Knight(String name, int health, int fear, Room currentRoom, Weapon currentWeapon) {
        super(name, health, fear, currentRoom, currentWeapon);
    }

    public void attack(Character enemy){
        enemy.reduceHealth(this.getCurrentWeapon().getDamage() + 2);
    }
}
