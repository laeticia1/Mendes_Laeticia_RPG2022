package isep.com.rpg;

public class Mage extends Hero {

    public Mage(String n, int mana){
        super(n,7, 4);
        this.mana = mana;
    }

    @Override
    public void fight (Combatant combatant) {
        combatant.loose(weapon.getDamagePoints());
    }

    @Override
    public void take(Item item) {
        if (item instanceof Weapon) {
            weapon=(Weapon) item;
        } else{
            Game.displayMessage("Oups !" + item.getName() + "est inutile...");
        }
    }
    private Weapon weapon;
    private final int mana;

}
