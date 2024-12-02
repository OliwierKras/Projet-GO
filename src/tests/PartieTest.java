package src.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import src.jeu.Partie;
import src.joueurs.Joueur;
import src.plateaux.Plateau;

public class PartieTest {
    private Partie partie = new Partie();

    @Test
    public void testBoardSize(){
        partie.lancerCommande("boardsize 7");
        assertEquals(partie.getPlateau().getTaille(), 7);
    }

    @Test
    public void testClearBoard(){
        partie.lancerCommande("clear_board");
        int boardSize = partie.getPlateau().getTaille();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                assertEquals(partie.getPlateau().getGrille()[i][j], '.');
            }
        }
    }

    @Test
    public void testPlay(){
        partie.lancerCommande("play black D5");
        assertEquals(partie.getPlateau().getPlacement(partie.getJoueurNoir())[0], 2);
        assertEquals(partie.getPlateau().getPlacement(partie.getJoueurNoir())[1], 3);

        partie.lancerCommande("play white C3");
        assertEquals(partie.getPlateau().getPlacement(partie.getJoueurBlanc())[0], 4);
        assertEquals(partie.getPlateau().getPlacement(partie.getJoueurBlanc())[1], 2);

        partie.lancerCommande("play black C3"); //Illegal move
        assertEquals(partie.getPlateau().getPlacement(partie.getJoueurNoir())[0], 2);
        assertEquals(partie.getPlateau().getPlacement(partie.getJoueurNoir())[1], 3);
    }

    @Test
    public void testShowBoard(){
        partie.lancerCommande("play black D5");
        partie.lancerCommande("play white C3");
        partie.lancerCommande("play black D2");
        partie.lancerCommande("play white F6");
        StringBuilder attenduBuiler = new StringBuilder(
                "  A B C D E F G \n" +
                "7 . . . . . . . 7\n" +
                "6 . . . . . O . 6\n" +
                "5 . . . X . . . 5\n" +
                "4 . . . . . . . 4\n" +
                "3 . . O . . . . 3\n" +
                "2 . . . X . . . 2\n" +
                "1 . . . . . . . 1\n" +
                "  A B C D E F G ");
        char[] attendu = attenduBuiler.toString().toCharArray();
        char[] plateau = partie.getPlateau().toString().toCharArray();
        System.out.println(partie.getPlateau().toString());
        for(int i = 0; i < attendu.length; ++i){
            assertEquals(attendu[i], plateau[i]);
        }
    }


    @Test
    public void testGenMove() {
        Partie partie = new Partie();
        partie.lancerCommande("boardsize 7");
        Plateau plateau = partie.getPlateau();
        Joueur joueurNoir = partie.getJoueurNoir();
        Joueur getJoueurBlanc = partie.getJoueurBlanc();
        boolean pionPlace = false;

        partie.lancerCommande("gen_move black");
        for (int i = 0; i < plateau.getTaille(); i++) {
            for (int j = 0; j < plateau.getTaille(); j++) {
                if (plateau.getGrille()[i][j] == joueurNoir.getLettre()) {
                    pionPlace = true;
                }
            }
        }
        assertTrue(pionPlace);

        partie.lancerCommande("gen_move white");
        pionPlace = false;
        for (int i = 0; i < plateau.getTaille(); i++) {
            for (int j = 0; j < plateau.getTaille(); j++) {
                if (plateau.getGrille()[i][j] == getJoueurBlanc.getLettre()) {
                    pionPlace = true;
                }
            }
        }
        assertTrue(pionPlace);
    }


}
