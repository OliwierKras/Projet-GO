package src.plateau;

import joueurs.Joueur;
import IHM.IJoueur;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private char[][] grille;
    public static final char VIDE = '.';
    private int taille = 7;

    public Plateau() {
        this.grille = new char[taille][taille];
        initialiserPlateau(taille);
    }

    public void initialiserPlateau(int taille) {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grille[i][j] = VIDE;
            }
        }
    }

    public void clearPlateau(){
        initialiserPlateau(taille);
    }

    public char[][] getGrille() {
        char[][] copieGrille = new char[grille.length][grille[0].length];
        for (int i = 0; i < grille.length; i++) {
            System.arraycopy(grille[i], 0, copieGrille[i], 0, grille[i].length);
        }
        return copieGrille;
    }

    public void setGrille(char[][] nouvelleGrille) {
        if (nouvelleGrille.length == grille.length && nouvelleGrille[0].length == grille[0].length) {
            for (int i = 0; i < grille.length; i++) {
                System.arraycopy(nouvelleGrille[i], 0, grille[i], 0, nouvelleGrille[i].length);
            }
        } else {
            throw new IllegalArgumentException("La taille de la nouvelle grille ne correspond pas à la grille actuelle.");
        }
    }

    public void setTaille(int nouvelleTaille){
        grille = new char[nouvelleTaille][nouvelleTaille];
        taille = nouvelleTaille;
        initialiserPlateau(nouvelleTaille);
    }

    public boolean coupPossible(int ligne, int colonne){
        if (ligne < 0 || ligne >= this.getTaille() || colonne < 0 || colonne >= this.getTaille()) {
            return false;
        }
        return grille[ligne][colonne] == VIDE;
    }

    public void appliquerCoup(String coup, String couleur) {
        int colonne = coup.charAt(0) - 'A';
        int ligne = taille - Character.getNumericValue(coup.charAt(1));
        if (grille[ligne][colonne] == VIDE) {
            grille[ligne][colonne] = couleur.equals("white") || couleur.equals("W") || couleur.equals("w") ? 'O' : 'X';
        } else {
            throw new IllegalArgumentException("Case déjà occupée");
        }
    }

    public List<String> getCoupsPossibles() {
        List<String> coupsPossibles = new ArrayList<>();
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (grille[i][j] == VIDE) {
                    coupsPossibles.add("" + (char) ('A' + j) + (taille - i));
                }
            }
        }
        return coupsPossibles;
    }

    public boolean verifierVictoire(char couleur) {
        // Vérifier chaque position sur le plateau.
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (grille[i][j] == couleur) {
                    // Vérifie si une ligne de 5 pions existe dans toutes les directions
                    if (verifierLigne(i, j, 1, 0, couleur) || // Horizontal
                            verifierLigne(i, j, 0, 1, couleur) || // Vertical
                            verifierLigne(i, j, 1, 1, couleur) || // Diagonale descendante
                            verifierLigne(i, j, 1, -1, couleur)) { // Diagonale montante
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean verifierLigne(int x, int y, int dx, int dy, char couleur) {
        int compteur = 0;
        for (int i = 0; i < 5; i++) {
            int nx = x + i * dx;
            int ny = y + i * dy;
            // Si on sort des limites du plateau ou si la case n'est pas la couleur du joueur
            if (nx < 0 || ny < 0 || nx >= taille || ny >= taille || grille[nx][ny] != couleur) {
                return false;
            }
            compteur++;
        }
        return compteur == 5;
    }

    @Override
    public String toString() {
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

    public int getTaille() {
        return taille;
    }
}
