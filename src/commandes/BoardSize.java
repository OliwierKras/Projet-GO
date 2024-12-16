package src.commandes;

import src.IHM.*;

public class BoardSize implements ICommandeGTP {
    private IHM ihm;
    private int taille;

    public BoardSize(IHM ihm, int taille) {
        this.ihm = ihm;
        this.taille = taille;
    }

    public void executer() {
        ihm.getPlateau().setTaille(taille);
        System.out.println("=");
    }
}