package CharacterTests;

import Characters.Warriors.Dwarf;
import Characters.Warriors.Weapon;
import Characters.Warriors.WeaponType;
import Rooms.Room;
import com.sun.beans.WeakCache;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.*;

public class DwarfTest {
    Dwarf dwarf;
    Room room;
    Weapon fist;
    Weapon axe;


    @Before
    public void setUp(){

        fist = new Weapon(WeaponType.FIST);
        axe = new Weapon(WeaponType.AXE);

        room = new Room();
        dwarf = new Dwarf("Gimley", 10, 0, room, fist);
    }

    @Test
    public void canBeAttacked__true(){
        assertEquals(true, dwarf.getCanBeAttacked());
    }

    @Test
    public void canBeAttacked__false(){
        dwarf.goInvisible();
        assertFalse(dwarf.getCanBeAttacked());
    }

    @Test
    public void weaponListStartsWithFist(){
        assertEquals(1, dwarf.countWeapons());

    }

    @Test
    public void canAddWeapon(){
        dwarf.addWeapon(axe);
        assertEquals(2, dwarf.countWeapons());
    }

    @Test
    public void canRemoveWeapon(){
        dwarf.addWeapon(axe);
        dwarf.removeWeapon(axe);
        assertEquals(1, dwarf.countWeapons());
    }

    @Test
    public void canGetWeaponByIndex(){
        dwarf.addWeapon(axe);
        assertEquals(axe, dwarf.getWeaponByIndex(1));
    }

    @Test
    public void canGetWeaponIndexByWeapon(){
        dwarf.addWeapon(axe);
        assertEquals(1, dwarf.getWeaponIndexByWeapon(axe));
    }

    @Test
    public void canRemoveWeaponByIndex(){
        dwarf.addWeapon(axe);
        dwarf.removeWeapon(dwarf.getWeaponByIndex(1));
        assertEquals(1, dwarf.countWeapons());
    }

    @Test
    public void cantRemoveDefaultFistWeapon(){
        dwarf.removeWeapon(dwarf.getWeaponByIndex(0));
        assertEquals(1, dwarf.countWeapons());
    }

    @Test
    public void canGetWeaponDamage(){
        assertEquals(1, dwarf.getWeaponByIndex(0).getDamage() );
    }







}
