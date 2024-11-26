package src.joueurs;

import src.partie.Plateau;

public class Joueur {
    private String couleur;

    public Joueur(String couleur){
        this.couleur = couleur;
    }


    public String getCouleur() {
        return couleur;
    }

    public char getLettre(){
        return couleur.equals("white") ? 'O' : 'X';
    }
}
