package isep.com.rpg;

public class Potion extends Consumable{

    private final int pointLife;

    public int getPointLife(){
        return pointLife;
    }

    public Potion(String name, int pointLife){
        super(name);
        this.pointLife = pointLife;
    }

    public void takePotion(Hero hero, Potion potion) {
        // Vérifie que l'objet passé en paramètre est bien une instance de la classe Potion
        if (potion instanceof Potion) {
                // Applique les effets de la potion
                hero.winLife(potion.getPointLife());
            }
        }

    }

