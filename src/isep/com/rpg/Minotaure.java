package isep.com.rpg;

public class Minotaure extends Enemy{

    public Minotaure (String n){
        //4 points de vie et 5 points de degats
        super(n, 4,5);
    }

    @Override
    public void fight(Combatant combatant){
        combatant.loose(getDamagePoints() );
    }


}
