package gameobjects;

public class Thing {
    private String name;
    private String description;
    private boolean takeable;
    private boolean fightable;
    private boolean eatable;
    private boolean drinkable;

    public Thing(String name, String description, boolean canTake, boolean canFight, boolean canEat, boolean canDrink){
        this.name = name;
        this.description = description;
        this.takeable = canTake;
        this.fightable = canFight;
        this.eatable = canEat;
        this.drinkable = canDrink;
    }

    //below constructor can be used for Room objects for example
    public Thing(String name, String description){
        this.name = name;
        this.description = description;
        this.takeable = false;
        this.fightable = false;
        this.eatable = false;
        this.drinkable = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTakeable() {
        return takeable;
    }

    public boolean isFightable() {
        return fightable;
    }

    public boolean isEatable() {
        return eatable;
    }

    public boolean isDrinkable() {
        return drinkable;
    }

}
