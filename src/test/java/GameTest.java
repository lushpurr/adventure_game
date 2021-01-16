import game.Game;
import gameobjects.ThingList;
import gameobjects.actors.Enemy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    Enemy enemy1;
    Enemy enemy2;
    ThingList warlockList;

    @Before
    public void setUp(){
        game = new Game();
        warlockList = new ThingList();
        enemy1 = new Enemy("warlock", "a fearsome warlock", false, true, false, false, warlockList,10, 3 );
        enemy2 = new Enemy("troll", "a troll", false, true, false, false, warlockList, 10, 4);

    }

    @Test
    public void canReturnEnemyFromList(){
        game.addEnemyToList(enemy1);
        game.addEnemyToList(enemy2);
        assertEquals(enemy1, game.returnEnemyFromList("warlock"));
    }

}
