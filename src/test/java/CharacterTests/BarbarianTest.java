package CharacterTests;

import Characters.Warriors.Barbarian;
import Characters.Warriors.Dwarf;
import Characters.Warriors.Weapon;
import Characters.Warriors.WeaponType;
import Rooms.Room;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarbarianTest {
    Barbarian barbarian;
    Dwarf dwarf;
    Room room;
    Weapon fist;
    Weapon axe;


    @Before
    public void setUp() {

        fist = new Weapon(WeaponType.FIST);
        axe = new Weapon(WeaponType.AXE);

        room = new Room();
        barbarian = new Barbarian("Bob", 10, 0, room, fist);
        dwarf = new Dwarf("Gimley", 10, 0, room, fist);
    }

    @Test
    public void canInflictGreaterDamage() {
        barbarian.attack(dwarf);
        assertEquals(7, dwarf.getHealth());
    }

}

