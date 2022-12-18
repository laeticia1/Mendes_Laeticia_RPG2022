package isep.com.rpg;

public class Food {
    String name;

    private int pointLife;

    public int getPointLife(){
        return pointLife;
    }

    public void setPointLife(int pointLife) {
        this.pointLife = pointLife;
    }

    public Food(String name, int pointLife){
        super();
        this.pointLife = pointLife;
    }
}
