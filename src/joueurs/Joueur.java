package src.joueurs;

import src.partie.Plateau;

public class Joueur {
    private String couleur;
    private Plateau plateau;

    public Joueur(String couleur, Plateau plateau){
        this.couleur = couleur;
        this.plateau = plateau;
    }

    public void jouer(char colonne, int ligne){
        plateau.placerPion(this, colonne, ligne);
    }

    public String getCouleur() {
        return couleur;
    }

    public char getLettre(){
        return couleur.equals("white") ? 'O' : 'X';
    }
}
