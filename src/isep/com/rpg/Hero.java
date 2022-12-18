package isep.com.rpg;

public abstract class Hero extends Combatant {

    private boolean isDefending = false;

    protected int armor;
    int healthPoints;

    public Hero(String n, int hp, int d) {
        super(n, hp, d);
    }

    public abstract void take (Item item);

    public String toString(){
        return this.getName();
    }

    public int getHealthPoint() {
        return healthPoint ;
    }



}
