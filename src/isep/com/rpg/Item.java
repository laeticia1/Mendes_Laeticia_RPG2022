package isep.com.rpg;

public abstract class Item {

    public Item(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String name;
}
