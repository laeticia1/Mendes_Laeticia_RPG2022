package isep.com.rpg;

public class Hunter extends Hero {

    public Hunter (String n, int fleches){
        super(n,9,8);
        this.fleches = fleches;

    }

    @Override
    public void fight (Combatant combatant) {
        combatant.loose(weapon.getDamagePoints());
        fleches--;
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
    private int fleches;
}
