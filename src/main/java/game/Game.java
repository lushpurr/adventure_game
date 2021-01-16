package game;

import gameobjects.Thing;
import gameobjects.ThingList;
import gameobjects.actors.Actor;
import gameobjects.actors.Enemy;
import gameobjects.objects.Treasure;
import gameobjects.rooms.Room;
import globals.Direction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private ArrayList<Room> map; // the map - an ArrayList of Rooms
    private ArrayList<Enemy> enemies;
    private Actor player;  // the player - provides 'first person perspective'

    private List<String> commands = new ArrayList<>(Arrays.asList(
            "take", "drop", "look", "l", "i", "inventory", "fight",
            "n", "s", "w", "e"
             ));
    private List<String> objects = new ArrayList<>(Arrays.asList("shades", "ripped jeans",
            "key", "strange bubbling potion"));

    public Game() {
        this.map = new ArrayList<Room>(); // TODO: Make map a Generic list of Rooms
        this.enemies = new ArrayList<Enemy>();

        //-- create Enemies -- //
        ThingList warlockList = new ThingList();
        Enemy grahamTheWarlock = new Enemy("Graham the warlock", "a fearsome warlock", false, true, false, false, warlockList,10, 3 )

        // --- construct a new adventure ---


        ThingList coolRoomList = new ThingList();
        coolRoomList.add(new Treasure("shades", "A pair of stunning designer shades", true, false, false, false, 5));
        coolRoomList.add(new Treasure("ripped jeans", "Some stylishly ripped jeans with studs near the pockets", true, false, false, false, 4));

        ThingList hutList = new ThingList();
        hutList.add(new Treasure("key", "a small key, how interesting", true, false, false , false,10));
        hutList.add(grahamTheWarlock);

        ThingList forestList = new ThingList();
        forestList.add(new Treasure("strange bubbling potion", "a potion bubbling in a glass in the bushes", true, false, false, true, 3));


        ThingList playerlist = new ThingList();
        // Add Rooms to the map
        //                 Room( name,   description,                             N,        S,      W,      E )

        map.add(new Room("Forest", "A deep dark forest, there is an owl tit twooing somewhere", 1, 2, Direction.NOEXIT, Direction.NOEXIT, forestList));
        map.add(new Room("Tiny hut", "A tiny hut", Direction.NOEXIT, 0, 4, Direction.NOEXIT, warlockList));
        //add 'circle room' here
        //add 'start room' here
        map.add(new Room("Coolest Place Ever", "A glorious assortment of really, really cool things litter the room", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 1, coolRoomList));


        // create player and place in Room 0 (i.e. the Room at 0 index of map)

        //WE WOULD NEED TO CHANGE THE INDEX HERE
        player = new Actor("player", "a loveable game-player", playerlist, map.get(0), 20, 3);
    }

    // access methods
    // map
    private ArrayList getMap() {
        return map;
    }

    private void setMap(ArrayList aMap) {
        map = aMap;
    }

    // player
    private Actor getPlayer() {
        return player;
    }

    public void setPlayer(Actor aPlayer) {
        player = aPlayer;
    }

    // take and drop
    private void transferOb(Thing t, ThingList fromlist, ThingList tolist) {
        fromlist.remove(t);
        tolist.add(t);
    }

    private String takeOb(String obname) {
        String retStr = "";
        Thing t = player.getLocation().getThings().thisOb(obname);
        if (obname.equals("")) {
            obname = "nameless object"; // if no object specified
        }
        if (t == null) {
            retStr = "There is no " + obname + " here!";
        } else {
            transferOb(t, player.getLocation().getThings(), player.getThings());
            retStr = obname + " taken!";
        }
        return retStr;
    }

    private String dropOb(String obname) {
        String retStr = "";
        Thing t = player.getThings().thisOb(obname);
        if (obname.equals("")) {
            retStr = "You'll have to tell me which object you want to drop!"; // if no object specified
        } else if (t == null) {
            retStr = "You haven't got one of those!";
        } else {
            transferOb(t, player.getThings(), player.getLocation().getThings());
            retStr = obname + " dropped!";
        }
        return retStr;
    }

    private String fightEnemy(String obname) {
        String retStr = "";
        Thing enemyName = player.getLocation().getThings().thisOb(obname);
        if (obname.equals("")){
            retStr = "You'll have to tell me who you want to fight!";
        } else if (enemyName == null){
            retStr = "That enemy isn't here!";
        }else {
            Enemy enemy = returnEnemyFromList(obname);
            if (enemy.isFightable()){
                player.reduceHp(enemy.getAttackPoints());
                enemy.reduceHp(player.getFightPoints());
                retStr = "You engage in a fierce battle with " + enemy.getName() + ".\n"
                        + "You hit " + enemy.getName() + " and they lose " + player.getFightPoints() + "health points. \n"
                        + enemy.getName() + " hits you and you lose " + enemy.getAttackPoints() + " health points. \n";

            }
        }
    }

    private String isAnyoneDefeated(Actor player, Enemy enemy){
        if (player.getFightPoints() >= enemy.getHp()){
            return "player";
        }
        else if (enemy.getAttackPoints() >= player.getHp()){
            return "enemy";
        }
        else {
            return "no";
        }
    }

    private Enemy returnEnemyFromList(String obname) {
        Enemy enemy = null;
        String thingName = "";
        String enemyNameLowCase = obname.trim().toLowerCase();

        for(Enemy e : this.enemies) {
            thingName = e.getName().trim().toLowerCase();
            if(thingName.equals(enemyNameLowCase)){
                enemy = e;
            }
        }
        return enemy;
    }

    // move a Person (typically the player) to a Room
    private void moveActorTo(Actor p, Room aRoom) {
        p.setLocation(aRoom);
    }

    // move an Actor in direction 'dir'
    private int moveTo(Actor anActor, Direction dir) {
        // return: Constant representing the room number moved to
        // or NOEXIT
        //
        // try to move any Person (typically but not necessarily player)
        // in direction indicated by dir
        Room r = anActor.getLocation();
        int exit;

        switch (dir) {
            case NORTH:
                exit = r.getN();
                break;
            case SOUTH:
                exit = r.getS();
                break;
            case EAST:
                exit = r.getE();
                break;
            case WEST:
                exit = r.getW();
                break;
            default:
                exit = Direction.NOEXIT; // noexit - stay in same room
                break;
        }
        if (exit != Direction.NOEXIT) {
            moveActorTo(anActor, map.get(exit));
        }
        return exit;
    }

    private void movePlayerTo(Direction dir) {
        // if roomNumber = NOEXIT, display a special message, otherwise
        // display text (e.g. name and description of room)
        if (moveTo(player, dir) == Direction.NOEXIT) {
            showStr("No Exit!");
        } else {
            look();
        }
    }

    private void goN() {
        movePlayerTo(Direction.NORTH);
    }

    private void goS() {
        movePlayerTo(Direction.SOUTH);
    }

    private void goW() {
        movePlayerTo(Direction.WEST);
    }

    private void goE() {
        movePlayerTo(Direction.EAST);
    }

    private void look() {
        showStr("You are in the " + getPlayer().getLocation().describe());
    }

    private void showStr(String s) {
        System.out.println(s);
    }

    private void showInventory() {
        showStr("You have " + getPlayer().getThings().describeThings());
    }

    private String processVerb(List<String> wordlist) {
        String verb;
        String msg = "";
        verb = wordlist.get(0);
        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
        } else {
            switch (verb) {
                case "n":
                    goN();
                    break;
                case "s":
                    goS();
                    break;
                case "w":
                    goW();
                    break;
                case "e":
                    goE();
                    break;
                case "l":
                case "look":
                    look();
                    break;
                case "inventory":
                case "i":
                    showInventory();
                    break;
                default:
                    msg = verb + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }

    private String processVerbNoun(List<String> wordlist) {
        String verb;
        String noun;
        String msg = "";
        boolean error = false;
        verb = wordlist.get(0);
        noun = wordlist.get(1);
        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
            error = true;
        }
        if (!objects.contains(noun)) {
            msg += (noun + " is not a known noun!");
            error = true;
        }
        if (!error) {
            switch (verb) {
                case "take":
                    msg = takeOb(noun);
                    break;
                case "drop":
                    msg = dropOb(noun);
                    break;
                case "fight":
                    msg = fightEnemy(noun);
                default:
                    msg += " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }

    private String parseCommand(List<String> wordlist) {
        String msg;
        if (wordlist.size() == 1) {
            msg = processVerb(wordlist);
        } else if (wordlist.size() == 2) {
            msg = processVerbNoun(wordlist);
        } else {
            msg = "Only 2 word commands allowed!";
        }
        return msg;
    }

    private static List<String> wordList(String input) {
        String delims = "[ \t,.:;?!\"']+";
        List<String> strlist = new ArrayList<>();
        String[] words = input.split(delims);

        for (String word : words) {
            strlist.add(word);
        }
        return strlist;
    }

    public void showIntro() {
        String s;
        s = "You have fallen down a rabbit hole and arrived in\n"
                + "an underground cavern that smells strongly of troll.\n"
                + "Where do you want to go? [Enter n, s, w or e]?\n"
                + "(or enter q to quit)";
        showStr(s);
        look();
    }

    public String runCommand(String inputstr) {
        List<String> wordlist;
        String s = "ok";
        String lowstr = inputstr.trim().toLowerCase();
        if (!lowstr.equals("q")) {
            if (lowstr.equals("")) {
                s = "You must enter a command";
            } else {
                wordlist = wordList(lowstr);
                s = parseCommand(wordlist);
            }
        }
        return s;
    }

}