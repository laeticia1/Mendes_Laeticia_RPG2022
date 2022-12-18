package isep.com.rpg;

public abstract class Enemy extends Combatant {

    private final int damagePoints;

    public Enemy(String n, int hp, int d) {
        super(n, 5 ,2);
        this.damagePoints = d;
        this.healthPoint = hp;
    }

    public int getDamagePoints(){
        return damagePoints;
    }

    @Override
    public int getHealthPoint() {
        return super.getHealthPoint();
    }

    public String toString(){
        return this.getName();
    }


}
