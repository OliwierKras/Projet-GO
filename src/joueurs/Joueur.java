package src.joueurs;

import src.IHM.IJoueur;

public abstract class Joueur implements IJoueur {
    private String couleur;

    public Joueur(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public char getSymbole(){
        return this.couleur.equals("black") ? 'X' : 'O';
    }
}