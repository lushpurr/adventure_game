package gameobjects.Characters.Warriors;
import gameobjects.Characters.IInvisible;
import gameobjects.Rooms.Room;

public class Dwarf extends Warrior implements IInvisible {

    public Dwarf(String name, int health, int fear, Room currentRoom, Weapon currentWeapon) {
        super(name, health, fear, currentRoom, currentWeapon);
    }

    public void goInvisible(){
        this.setCanBeAttacked(false);
    }

}
