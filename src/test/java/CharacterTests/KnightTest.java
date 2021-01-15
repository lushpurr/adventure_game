package CharacterTests;

import oldobjects.Characters.Warriors.*;
import oldobjects.Rooms.Room;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    Knight knight;
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
        knight = new Knight("Julie", 10, 0, room, fist);
        barbarian = new Barbarian("Bob", 10, 0, room, axe);
        dwarf = new Dwarf("Gimley", 10, 0, room, fist);
    }

    @Test
    public void canGetLessDamage(){
        barbarian.attack(knight);
        assertEquals(6, knight.getHealth());

    }
}
