package isep.com.rpg;

public abstract class Enemy extends Combatant {

    String name;
    int healthPoints;
    int degats;

    public Enemy(String n, int hp, int d) {
        name = n;
        healthPoints = hp;
        degats = d;
    }

    public int getDegats(){
        return degats;
    }

    public int getHealthPoint() {
        return healthPoints ;
    }

    public String getName() {
        return name ;
    }

    public String toString(){
        return this.getName();
    }


}
