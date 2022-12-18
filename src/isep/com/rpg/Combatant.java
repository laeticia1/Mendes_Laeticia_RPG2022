package isep.com.rpg;

public abstract class Combatant {

    int degats;
    private final String name;
    public int healthPoint;

    int damagePoints;

    public Combatant(String n, int hp, int d) {
        name = n;
        healthPoint = hp;
        degats = d;
    }

    public String getName() {
        return name ;
    }


    public int getHealthPoint() {
        return healthPoint ;
    }

    public int getDamagePoints() { return damagePoints; }

    public int getDegats() {return degats; }

    protected void loose(int hp) {
        healthPoint -= hp;
    }

    public void winLife(int hp){
        healthPoint += hp;
    }

    public abstract void fight (Combatant combatant);

    public void winDegats(int d) { degats += d; }


}
