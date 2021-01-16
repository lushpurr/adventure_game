package gameobjects;

public class ThingHolder extends Thing {

    private ThingList things = new ThingList();

    public ThingHolder(String name, String description, boolean canTake, boolean canFight, boolean canEat, boolean canDrink, ThingList tl){
        super(name, description, canTake, canFight, canEat, canDrink);
        things = tl;
    }

    public ThingList getThings() {
        return things;
    }

    public void setThings(ThingList things) {
        this.things = things;
    }
}
