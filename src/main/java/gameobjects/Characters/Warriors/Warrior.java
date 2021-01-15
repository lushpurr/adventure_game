package gameobjects.Characters.Warriors;
import gameobjects.Characters.Character;
import gameobjects.Rooms.Room;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Warrior extends Character {
    private ArrayList<Weapon> weapons;
    private Weapon currentWeapon;
    private Weapon defaultFist;


    public Warrior(String name, int health, int fear, Room currentRoom, Weapon currentWeapon) {
        super(name, health, fear, currentRoom);
        this.weapons = new ArrayList<Weapon>(Arrays.asList(defaultFist= new Weapon(WeaponType.FIST)));
        this.currentWeapon = currentWeapon;
    }

    public ArrayList<Weapon> getWeapon() {
        return weapons;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public int countWeapons(){
        return this.weapons.size();
    }

    public void addWeapon(Weapon weapon){
        this.weapons.add(weapon);
    }

    public void removeWeapon(Weapon weapon){
        if (this.weapons.indexOf(weapon) != 0)
        {
            this.weapons.remove(weapon);
        }
    }

    public Weapon getWeaponByIndex(int index){
        return this.weapons.get(index);
    }

    public int getWeaponIndexByWeapon(Weapon weapon){
        return this.weapons.indexOf(weapon);
    }

    public void attack(Character enemy){
        if (enemy instanceof Knight){
            enemy.reduceHealth(this.currentWeapon.getDamage() -2);
        }
        else {
            enemy.reduceHealth(this.currentWeapon.getDamage());
        }
    }

}
