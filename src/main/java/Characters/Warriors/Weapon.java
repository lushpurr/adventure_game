package Characters.Warriors;

public class Weapon {

    private WeaponType weapon;

    public Weapon(WeaponType weapon) {
        this.weapon = weapon;

    }

    public WeaponType getWeapon() {
        return weapon;
    }

    public int getDamage(){
        return weapon.getDamage();
    }
}
