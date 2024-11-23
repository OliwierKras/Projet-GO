package src.partie;

import src.joueurs.Joueur;

public class Plateau {
    private int boardSize;
    private char [][] grille;

    public Plateau(int boardSize) {
        if (boardSize <= 0) {
            throw new IllegalArgumentException("La taille du plateau doit être positive");
        }
        this.boardSize = boardSize;
        grille = new char[boardSize][boardSize];
        initialiserPlateau(boardSize);
    }

    public void initialiserPlateau(int boardSize) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                grille[i][j] = '.';
            }
        }
    }

    public int[] getPlacement(Joueur joueur){
        int[] coordonnees = {-1, -1};
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
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
        int numLigne = this.getBoardSize() - ligne;
        int numColonne = colonne % 'A';

        if (numLigne < 0 || numLigne >= this.getBoardSize() || numColonne < 0 || numColonne >= this.getBoardSize()) {
            System.out.println("illegal move");
            return;
        }

        // Vérifie si la case cible est déjà occupée
        if (grille[numLigne][numColonne] != '.') {
            System.out.println("illegal move");
            return;
        }

        int[] placementJoueur = this.getPlacement(joueur);
        if (placementJoueur[0] != -1 && placementJoueur[1] != -1) {
            grille[placementJoueur[0]][placementJoueur[1]] = '.';
        }

        grille[numLigne][numColonne] = lettre;
    }


    public char[][] getGrille() {
        return grille;
    }

    public int getBoardSize(){
        return boardSize;
    }

    public void setBoardSize(int newBoardSize){
        grille = new char[newBoardSize][newBoardSize];
        boardSize = newBoardSize;
        initialiserPlateau(newBoardSize);
    }

    public void clearPlateau(){
        initialiserPlateau(boardSize);
    }

    @Override
    public String toString(){
        int numeroLigne = boardSize;
        int debut = 66;
        StringBuilder builder = new StringBuilder();

        builder.append("  ");
        for (char l = 'A'; l < (debut + boardSize) - 1; ++l) {
            builder.append(l).append(" ");
        }
        builder.append("\n");

        for (int i = 0; i < boardSize; i++) {
            builder.append(numeroLigne).append(" "); // Numéro de ligne à gauche
            for (int j = 0; j < boardSize; j++) {
                builder.append(grille[i][j]).append(" "); // Contenu de la ligne
            }
            builder.append(numeroLigne--).append("\n"); // Numéro de ligne à droite
        }

        builder.append("  ");
        for (char l = 'A'; l < (debut + boardSize) - 1; ++l) {
            builder.append(l).append(" ");
        }

        return builder.toString();
    }

    public void printPlateau(){
        System.out.println(this.toString());
    }
}
