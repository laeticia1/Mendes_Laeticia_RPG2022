package isep.com.rpg;
import java.util.Scanner;


public class AideConsole {

    Scanner scanner = new Scanner(System.in);

    public int oInt(String prompt, int Choices){
        int input;

        do {
            System.out.println(prompt);

            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Mauvais choix, merci de recommencer");
            }

        }while(input < 1 || input > Choices);
        return input;
    }
}
