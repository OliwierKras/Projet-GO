package src.commandes;

import src.IHM.*;

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
        if (position == null) {
            return;
        }

        int ligne = ihm.getPlateau().getTaille() - Character.getNumericValue(position.charAt(1));
        if(position.length() > 2){
            String ligneString = position.charAt(1)+""+position.charAt(2);
            ligne = ihm.getPlateau().getTaille() - Integer.parseInt(ligneString);
        }
        int colonne = position.charAt(0) - 'A';
        if (ihm.getPlateau().coupPossible(ligne, colonne)) {
            ihm.getPlateau().appliquerCoup(position, couleur);
            System.out.print("=");
        } else {
            System.out.println("? illegal move");
        }
    }

}
