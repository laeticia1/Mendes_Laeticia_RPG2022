package isep.com.rpg;

public abstract class Enemy extends Combatant {

    public Enemy(String n, int hp, int d) {
        super(n, 5, 2);
        this.damagePoints = d;
    }

    public int getDamagePoints(){
        return damagePoints;
    }

    private final int damagePoints;

    public String toString(){
        return this.getName();
    }
}
