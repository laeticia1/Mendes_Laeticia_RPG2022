package isep.com.rpg;

import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Random rnd = new Random(28);
        Scanner scan = new Scanner(System.in);
        int ent = rnd.nextInt();

        Game game = new Game();
        game.game();
    }
}