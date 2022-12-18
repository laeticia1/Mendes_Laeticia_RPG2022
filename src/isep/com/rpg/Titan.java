package isep.com.rpg;

public class Titan extends Enemy{

    public Titan (String n){
        //5 points de vie et 6 points de degats
        super(n, 5,6);
    }

    @Override
    public void fight(Combatant combatant){
        combatant.loose(getDamagePoints() );
    }

}
