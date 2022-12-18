package isep.com.rpg;

public class Dragon extends Enemy{

    public Dragon (String n){
        //5 points de vie et 3 points de degats
        super(n, 5,3);
    }

    @Override
    public void fight(Combatant combatant){
        combatant.loose(getDamagePoints() );
    }

}
