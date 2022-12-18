package com.isep.jfx;
import javax.swing.*;

public class GameController {
        public static void main(String[] args) {
            // Créer une nouvelle fenêtre
            JFrame frame = new JFrame("RPG");

            // Définir la taille de la fenêtre
            frame.setSize(1000, 800);

            // Créer un bouton
            JButton button = new JButton("Lancer le jeu");

            // Ajouter le bouton à la fenêtre
            frame.add(button);

            // Afficher la fenêtre
            frame.setVisible(true);
        }
    }


