package gameobjects;

public class ThingHolder extends Thing {

    private ThingList things = new ThingList();

    public ThingHolder(String name, String description, ThingList tl){
        super(name, description);
        things = tl;
    }

    public ThingList getThings() {
        return things;
    }

    public void setThings(ThingList things) {
        this.things = things;
    }
}
