package src.commandes;

import src.IHM.*;
import src.plateau.Plateau;

import java.util.Random;

public class GenMove implements ICommandeGTP {
    private IHM ihm;
    private String couleur;
    private int profondeur;

    public GenMove(IHM ihm, String couleur) {
        this.ihm = ihm;
        this.couleur = couleur;
        this.profondeur = 3;
    }

    public void setProfondeur(int profondeur){
        this.profondeur = profondeur;
    }

    @Override
    public void executer() {
        Plateau plateau = ihm.getPlateau(); // Récupère le plateau du jeu
        int bestScore = Integer.MIN_VALUE;
        String bestMove = null;

        // Sauvegarde l'état initial du plateau
        char[][] sauvegardePlateau = plateau.getGrille();

        // Explore tous les coups possibles
        for (String coup : plateau.getCoupsPossibles()) {
            plateau.appliquerCoup(coup, this.couleur); // Applique le coup du bot
            int score = minimax(plateau, profondeur, false, Integer.MIN_VALUE, Integer.MAX_VALUE, sauvegardePlateau); // Évalue la position

            // Restaure l'état du plateau avant de tester un autre coup
            plateau.setGrille(sauvegardePlateau);

            // Choisit le meilleur coup
            if (score > bestScore) {
                bestScore = score;
                bestMove = coup;
            }
        }

        // Applique le meilleur coup trouvé
        Play commandePlay = new Play(ihm, this.couleur, bestMove);
        commandePlay.executer(); // Applique le coup via la commande
        System.out.println(bestMove); // Affiche le coup choisi
    }

    // Fonction Minimax récursive
    private int minimax(Plateau plateau, int depth, boolean isMaximizingPlayer, int alpha, int beta, char[][] sauvegardePlateau) {
        if (depth == 0 || plateau.verifierVictoire('O') || plateau.verifierVictoire('X')) {
            return evaluate(plateau); // Retourne la valeur de la position
        }

        int bestScore = isMaximizingPlayer ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (String coup : plateau.getCoupsPossibles()) {
            plateau.appliquerCoup(coup, isMaximizingPlayer ? "white" : "black"); // Applique le coup
            int score = minimax(plateau, depth - 1, !isMaximizingPlayer, alpha, beta, sauvegardePlateau); // Appel récursif
            plateau.setGrille(sauvegardePlateau); // Restaure l'état du plateau après l'appel récursif

            if (isMaximizingPlayer) {
                bestScore = Math.max(bestScore, score);
                alpha = Math.max(alpha, bestScore);
            } else {
                bestScore = Math.min(bestScore, score);
                beta = Math.min(beta, bestScore);
            }

            // Alpha-Beta Pruning
            if (beta <= alpha) {
                break; // Coupe les branches non intéressantes
            }
        }

        return bestScore;
    }

    // Fonction d'évaluation simple (vous pouvez l'améliorer)
    private int evaluate(Plateau plateau) {
        if (plateau.verifierVictoire('O')) {
            return 10; // Victoire du bot
        } else if (plateau.verifierVictoire('X')) {
            return -10; // Victoire de l'adversaire
        }
        return 0; // Aucun gagnant
    }
}
