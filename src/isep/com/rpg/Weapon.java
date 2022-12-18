package isep.com.rpg;

public class Weapon extends Item {

    private int damagePoints;

    public Weapon (String name, int damagePoints){
        super(name);
        this.damagePoints = damagePoints;

    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints){
        this.damagePoints = damagePoints;
    }
     public String toString(){
        return name;
     }

}
