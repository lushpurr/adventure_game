package oldobjects.Characters.Warriors;

import oldobjects.Characters.Character;
import oldobjects.Rooms.Room;

public class Barbarian extends Warrior {

    public Barbarian(String name, int health, int fear, Room currentRoom, Weapon currentWeapon) {
        super(name, health, fear, currentRoom, currentWeapon);
    }

    //Barbarian Inflicts Greater Damage
    public void attack(Character enemy){
        if (enemy instanceof Knight){
            enemy.reduceHealth(this.getCurrentWeapon().getDamage());
        }
        else {
            enemy.reduceHealth(this.getCurrentWeapon().getDamage() + 2);
        }
    }
}
