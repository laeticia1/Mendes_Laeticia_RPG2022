package isep.com.rpg;
//ffffff

import com.isep.utils.InputParser;

import java.util.*;

public class Game {

    private final AideConsole ac = new AideConsole();
    private int mana;
    Potion potion = new Potion("Potion de vie", 5);

    public void game() {

        heros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String name;

            // Introduction
        System.out.println("Bienvenue sur ce jeu !");
        System.out.println (Separator(30));
        System.out.println("Entrez votre prénom :");
        name = scanner.next();
        System.out.println (Separator(30));
        System.out.println("Bonjour" + " " + name + " " + "!");


            int choix = ac.oInt("Vous pouvez choisir entre 1 et 5 héros pour votre équipe : ", 5);
            for (int i = 0; i < choix ; i++){
                System.out.println("Choisissez le nom du heros " + (i+1));
                scanner.nextLine();
                String nom = scanner.next();
                System.out.println("Choisissez le type de heros (veuillez entrer le numéro correspondant) : \nn°1 Warrior \nn°2 Healer \nn°3 Mage \nn°4 Hunter");
                int nombre = scanner.nextInt();
                switch (nombre){
                    case 1 :
                        heros.add(new Warrior(nom, 8, 7));
                        int arme = ac.oInt("Vous allez maintenant devoir choisir une arme pour votre héros :" +
                                " vous avez le choix entre (1) Epée et (2) Poignard",2 );
                        if(arme == 1){
                            Weapon epee = new Weapon("Epee", 4);
                            heros.get(i).take(epee);
                            System.out.println("Vous venez de choisir " + heros.get(i) + " avec l'arme " + epee);
                        }
                        if(arme == 2){
                            Weapon poignard = new Weapon("Poignard", 2);
                            heros.get(i).take(poignard);
                            System.out.println("Vous venez de choisir " + heros.get(i) + " avec l'arme " + poignard);
                        }
                        break;
                    case 2 :
                      displayMessage("Le Healer ne posède pas d'arme : il soigne son équipe avec des sorts ");
                        break;
                    case 3 :
                        heros.add(new Mage(nom,10));
                        int arme3 = ac.oInt("Vous allez maintenant devoir choisir une arme pour votre héros :" +
                                " vous avez le choix entre (1) Baton et (2) Cloche magique",2);
                        if(arme3 == 1){
                            Weapon baton = new Weapon("Baton", 3);
                            heros.get(i).take(baton);
                            System.out.println("Vous venez de choisir " + heros.get(i) + " avec l'arme " + baton);
                        }
                        if(arme3 == 2){
                            Weapon cloche = new Weapon("Cloche magique ", 1);
                            heros.get(i).take(cloche);
                            System.out.println("Vous venez de choisir " + heros.get(i) + " avec l'arme " + cloche);
                        }
                        break;
                    case 4 :
                        heros.add(new Hunter(nom,5));
                        int arme4 = ac.oInt("Vous allez maintenant devoir choisir une arme pour votre héros :" +
                                " vous avez le choix entre (1) Flèche et (2) Flèches de Feu", 2);
                        if(arme4 == 1){
                            Weapon fleche = new Weapon("Flèches", 1);
                            heros.get(i).take(fleche);
                            System.out.println("Vous venez de choisir " + heros.get(i) + " avec l'arme " + fleche);
                        }
                        if(arme4 == 2){
                            Weapon fleche_feu = new Weapon("Flèches de feu", 3);
                            heros.get(i).take(fleche_feu);
                            System.out.println("Vous venez de choisir " + heros.get(i) + " avec l'arme " + fleche_feu);
                        }
                        break;
                }
            }

            System.out.println (Separator(30));
            System.out.println("Voici la composition de votre équipe : " + heros);


            // Liste d'ennemis :
        enemies = new ArrayList<>();
        enemies.add(new Dragon("Dragon"));
        enemies.add(new Cyclope("Cyclope"));
        enemies.add(new Minotaure("Minotaure"));
        enemies.add(new Titan("Titan"));
        Collections.shuffle(enemies);
        enemies.add(new Boss("Boss"));

        System.out.println("Voici la composition de vos enemies : "+ enemies);
        System.out.println (Separator(30));

        // Faire prendre une arme aux héros

        start();

    }


    public void start() {

        Scanner scanner = new Scanner(System.in);

        // Choisir le héros à controller
        // Choisir l'ennemi à attaquer

        int ixHero = 0;

        // Boucle de jeu
        while (true) {

            displayStatus(heros, enemies);

            Random r = new Random();
            int premierattaquant = r.nextInt(2);
            if (premierattaquant == 0) System.out.println("Les ennemis commencent à attaquer");
            if (premierattaquant == 1) System.out.println("Les héros commencent le combat");

            ixHero = ac.oInt("Quel héros souhaitez-vous sélectionner dans la liste (saisir sa position)" + heros, 5);
            scanner.nextInt();

            Combatant goodOne = heros.get(ixHero - 1);
            Combatant badOne = enemies.get(0);

            switch (premierattaquant) {

                case 0:
                    // Attaque de l'ennemi
                    displayMessage("Le méchant " + badOne.getName()
                            + " attaque le gentil " + goodOne.getName() + "...");
                    badOne.fight(goodOne);
                    if (goodOne.getHealthPoint() <= 0) {
                        displayMessage("Le pauvre " + goodOne.getName() + " a été vaincu...");
                        heros.remove(ixHero - 1);
                        ixHero--; // Correction: évite que le suivant perde son tour
                    } else {

                        //Riposte du gentil
                        displayMessage(" Le gentil " + goodOne.getName() + " attaque le méchant " + badOne.getName() + "...");
                        goodOne.fight(badOne);
                        if (badOne.getHealthPoint() <= 0) {
                            displayMessage("Bravo, " + goodOne.getName()
                                    + " a vaincu " + badOne.getName() + " !!!");
                            enemies.remove(0);
                            recompense(heros);
                        }

                    }
                    break;

                case 1:
                    //Les héros commencent
                    // Attaque du gentil
                    displayMessage("Le gentil " + goodOne.getName()
                            + " attaque le méchant " + badOne.getName() + "...");
                    goodOne.fight(badOne);
                    if (badOne.getHealthPoint() <= 0) {
                        displayMessage("Bravo, " + goodOne.getName()
                                + " a vaincu " + badOne.getName() + " !!!");
                        enemies.remove(0);
                        recompense(heros);
                    } else {

                        // Riposte du méchant, s'il n'est pas vaincu
                        displayMessage("Le méchant " + badOne.getName()
                                + " attaque le gentil " + goodOne.getName() + "...");
                        badOne.fight(goodOne);
                        if (goodOne.getHealthPoint() <= 0) {
                            displayMessage("Le pauvre " + goodOne.getName() + " a été vaincu...");
                            heros.remove(ixHero - 1);
                            ixHero--;
                        }
                    }
                    break;
            }


        // Tests de fin du jeu


        if(heros.size() == 0){
            System.out.println("Les héros ont perdus, c'est la FIN ");
            break;
        }


        if (enemies.size() == 0) {
            displayMessage("BRAVO, les héros ont gagnés !!!");
            break;
        }


    }

            // Au tour du héro suivant
            ixHero = (ixHero + 1) % heros.size();
        }



    private InputParser inputParser;
    private List<Hero> heros;
    private List<Combatant> enemies;


    // Méthodes d'affichage
    // (STATIQUES pour pouvoir les appeler depuis n'importe où dans le programme)
    //
    // => pourraient éventuellement être déplacées dans le package
    //    "com.isep.utils", en s'inspirant de "com.isep.utils.InputParser" (méthodes de saisie)

    public static void displayStatus(List<Hero> h, List<Combatant> e) {
        System.out.println(Separator(30));
        for (Combatant c: h) {
            System.out.print(c.getName() + "(" + c.getHealthPoint() + ") ");
        }
        System.out.println();
        for (Combatant c: e) {
            System.out.print(c.getName() + "(" + c.getHealthPoint() + ") ");
        }
        System.out.println();
        System.out.println(Separator(30));
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    private static String Separator(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s +="-";
        }
        return s;
    }

    public static void recompense(List<Hero> heros){
        displayMessage("Vous venez de remporter un combat : vous avez le choix entre les récomposes suivantes : (1) Augmenter la vie de vos héros ; (2) Augmenter les degats d'un seul héros ");
        Scanner scanner = new Scanner(System.in);
        int choix_recompense = scanner.nextInt();
        if(choix_recompense==1){
            for(Combatant c:heros){
                c.winLife(1);
            }
            displayMessage("Les vies de vos héros ont augmentées de 1. ");
        }
        displayMessage("Choisissez l'héros que vous voulez augmenter. Saisir sa position : " + heros);
        for(Combatant c:heros){
            c.winDegats(1);
        }
        displayMessage("Les dégats de votre héros ont augmentés.");
    }


}