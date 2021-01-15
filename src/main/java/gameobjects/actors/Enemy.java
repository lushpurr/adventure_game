package gameobjects.actors;

import gameobjects.ThingHolder;
import gameobjects.ThingList;

public class Enemy extends ThingHolder {

    private int hp;
    private int attackPoints;

    public Enemy(String name, String description, ThingList tl, int hp, int attackPoints){
        super(name, description, tl);
        this.hp = hp;
        this.attackPoints = attackPoints;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }
}
