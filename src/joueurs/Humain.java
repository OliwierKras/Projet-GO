package src.joueurs;

import src.commandes.*;
import src.IHM.IHM;

import java.util.Scanner;

public class Humain extends Joueur {
    private Scanner scanner;

    public Humain(String couleur) {
        super(couleur);
        scanner = new Scanner(System.in);
    }

    @Override
    public void genMove(IHM ihm) {
        String coup = scanner.nextLine();
        new Play(ihm, this.getCouleur(), coup).executer();
    }
}