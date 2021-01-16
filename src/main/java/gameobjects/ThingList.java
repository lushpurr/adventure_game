package gameobjects;

import gameobjects.actors.Enemy;

import java.util.ArrayList;

public class ThingList extends ArrayList<Thing> {
    public String describeThings(){
        String s = "";
        if (this.size()== 0){
            s = "nothing.\n";
        }else{
            for(Thing t : this){
                s = s + t.getName() + ":" + t.getDescription() + "\n";
            }
        }
        return s;
    }

    public Thing thisOb(String name){
        Thing thing = null;
        String thingName = "";
        String nameLowCase = name.trim().toLowerCase();

        for(Thing t : this){
            thingName = t.getName().trim().toLowerCase();
            if(thingName.equals(nameLowCase)){
                thing = t;
            }
        }
        return thing;
    }

}
