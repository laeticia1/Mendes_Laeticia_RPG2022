package isep.com.rpg;

public class Warrior extends Hero {

    public Warrior(String n, int hp, int d) {
        super(n,8,7);

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

}
