package src.commandes;

import IHM.*;

public class Play implements ICommandeGTP {
    private IHM ihm;
    private final String couleur;
    private final String position;

    public Play(IHM ihm, String couleur, String position) {
        this.ihm = ihm;
        this.couleur = couleur;
        this.position = position;
    }

    public void executer() {
        int ligne = ihm.getPlateau().getTaille() - Character.getNumericValue(position.charAt(1));
        int colonne = position.charAt(0) - 'A';

        if(ihm.getPlateau().coupPossible(ligne, colonne)){
            ihm.getPlateau().appliquerCoup(position, couleur);
            System.out.println("=");
        }else{
            System.out.println("? illegal move");
        }
    }
}
