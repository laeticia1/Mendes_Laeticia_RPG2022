package isep.com.rpg;

public class Healer extends SpellCaster{

    @Override
    public int getMana(){
        return mana;
    }

    @Override
    public void setMana(int mana){
        this.mana = mana;
    }

    public void setCarePoints(int carePoints) {
        this.carePoints = carePoints;
    }

    private int mana;


    private int carePoints;

    public Healer(String name, int mana, int carePoints ) {
        super(name,5, 0);
        this.mana = mana;
        this.carePoints = carePoints;

    }

    @Override
    public void fight (Combatant combatant) {
        if (mana>0){
            combatant.winLife(this.degats);
            mana--;
        }
        else{
            System.out.println("Votre Healer est à court de mana, il ne plus soigner ses camarades ");
        }
    }

    private Potion potion;

    @Override
    public void take(Item item) {
        if (item instanceof Potion) {
            potion =(Potion) item;
        } else{
            Game.displayMessage("Oups !" + item.getName() + "est inutile...");
        }
    }

    public Weapon getWeapon(){
        return null;
    }
}
