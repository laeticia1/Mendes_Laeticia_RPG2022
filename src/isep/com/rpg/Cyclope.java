package isep.com.rpg;

public class Cyclope extends Enemy {

    public Cyclope (String n){
        //6 points de vie et 2 points de degats
        super(n, 6,2);
    }

    @Override
    public void fight(Combatant combatant){
        combatant.loose(getDegats() );
    }

}