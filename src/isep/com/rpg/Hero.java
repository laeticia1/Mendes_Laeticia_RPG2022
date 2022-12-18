package isep.com.rpg;

public abstract class Hero extends Combatant {

    private boolean isDefending = false;

    protected int armor;
    protected int lifePoints;

    public Hero(String n, int hp, int d) {
        super(n, hp, d);
    }

    public abstract void take (Item item);

    public String toString(){
        return this.getName();
    }

    public boolean isDefending() {
        if (isDefending) {
            isDefending = false;
            return true;
        }
        return false;
    }


    public void Defend(){
        System.out.println(getName() + " se défend d'une future attaque ");
        isDefending= true;
    }


    public int getLife(){
        return Math.max(0, lifePoints);
    }


}
