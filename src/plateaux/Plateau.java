package src.plateaux;

import src.joueurs.Joueur;

import java.util.Random;

public class Plateau {
    public static final int DEFAULT_TAILLE_PLATEAU = 7;
    public static final char VIDE = '.';
    private int taille;
    private char [][] grille;

    public Plateau(int taille) {
        if (taille <= 0) {
            throw new IllegalArgumentException("La taille du plateau doit être positive");
        }
        this.taille = taille;
        grille = new char[taille][taille];
        initialiserPlateau(taille);
    }

    public Plateau(){
        this(DEFAULT_TAILLE_PLATEAU);
    }

    public void initialiserPlateau(int taille) {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grille[i][j] = VIDE;
            }
        }
    }

    public int[] getPlacement(Joueur joueur){
        int[] coordonnees = {-1, -1};
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (grille[i][j] == joueur.getLettre()){
                    coordonnees[0] = i;
                    coordonnees[1] = j;
                    return coordonnees;
                }
            }
        }
        return coordonnees;
    }

    public void placerPion(Joueur joueur, char colonne, int ligne) {
        char lettre = joueur.getLettre();
        int numLigne = this.getTaille() - ligne;
        int numColonne = colonne % 'A';

        //Case en dehors de la dimension du plateau
        if (numLigne < 0 || numLigne >= this.getTaille() || numColonne < 0 || numColonne >= this.getTaille()) {
            System.out.println("illegal move");
        }
        //Case occupée
        else if(grille[numLigne][numColonne] != VIDE){
            System.out.println("illegal move");
        }
        else{
            grille[numLigne][numColonne] = lettre;
        }
    }
    public void genMove(Joueur joueur){
        Random rand = new Random();
        int randLine = rand.nextInt(this.getTaille()) + 1;
        char randChar = (char) (rand.nextInt(this.getTaille()) + 'A');
        placerPion(joueur, randChar, randLine);
    }


    public char[][] getGrille() {
        return grille;
    }

    public int getTaille(){
        return taille;
    }

    public void setTaille(int nouvelleTaille){
        grille = new char[nouvelleTaille][nouvelleTaille];
        taille = nouvelleTaille;
        initialiserPlateau(nouvelleTaille);
    }

    public void clearPlateau(){
        initialiserPlateau(taille);
    }

    @Override
    public String toString(){
        int numeroLigne = taille;
        int debut = 66;
        StringBuilder builder = new StringBuilder();

        builder.append("  ");
        for (char l = 'A'; l < (debut + taille) - 1; ++l) {
            builder.append(l).append(" ");
        }
        builder.append("\n");

        for (int i = 0; i < taille; i++) {
            builder.append(numeroLigne).append(" "); // Numéro de ligne à gauche
            for (int j = 0; j < taille; j++) {
                builder.append(grille[i][j]).append(" "); // Contenu de la ligne
            }
            builder.append(numeroLigne--).append("\n"); // Numéro de ligne à droite
        }

        builder.append("  ");
        for (char l = 'A'; l < (debut + taille) - 1; ++l) {
            builder.append(l).append(" ");
        }

        return builder.toString();
    }

    public void printPlateau(){
        System.out.println(this.toString());
    }
}
