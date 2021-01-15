package CharacterTests;

import gameobjects.Characters.Warriors.Barbarian;
import gameobjects.Characters.Warriors.Dwarf;
import gameobjects.Characters.Warriors.Weapon;
import gameobjects.Characters.Warriors.WeaponType;
import gameobjects.Rooms.Room;
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

