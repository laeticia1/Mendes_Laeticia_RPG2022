package isep.com.rpg;

public class Boss extends Enemy{

    public Boss (String n){
        //12 points de vie et 9 points de degats
        super(n, 12,9);
    }

    @Override
    public void fight(Combatant combatant){
        combatant.loose(getDamagePoints() );
    }

}
