package isep.com.rpg;

public class Titan extends Enemy{

    public Titan (String n){
        //5 points de vie et 6 points de degats
        super(n, 7,5);
    }

    @Override
    public void fight(Combatant combatant){
        combatant.loose(getDamagePoints() );
    }

}
