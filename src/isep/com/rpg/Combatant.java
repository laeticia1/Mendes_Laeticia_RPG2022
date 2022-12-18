package isep.com.rpg;

public abstract class Combatant {

    int degats;
    private String name;
    private int healthPoint;

    public Combatant(String n, int hp, int d) {
        name = n;
        healthPoint = hp;
        degats = d;
    }

    protected Combatant() {
    }

    public String getName() {
        return name ;
    }

    public void setName(String name){
        this.name = name ;
    }


    public int getHealthPoint() {
        return healthPoint ;
    }

    public int getDegats() { return degats; }

    protected void loose(int hp) {
        healthPoint -= hp;
    }

    public void winLife(int hp){
        healthPoint += hp;
    }

    public abstract void fight (Combatant combatant);

    public void winDegats(int d) { degats += d; }

    Potion potion = new Potion("Potion de vie", 5);

}
