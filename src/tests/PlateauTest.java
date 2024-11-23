package src.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import src.joueurs.Joueur;
import org.junit.jupiter.api.Test;
import src.partie.Plateau;

public class PlateauTest {
    @Test
    public void testTaillePlateau(){
        Plateau plateau = new Plateau(7);
        assertEquals(7, plateau.getBoardSize());
    }

    @Test
    public void afficherPlateau(){
        Plateau plateau = new Plateau(7);
        Joueur joueurUn = new Joueur("white", plateau);
        joueurUn.placerPion('D', 5);
        joueurUn.placerPion('E', 7);
        joueurUn.placerPion('B', 2);
        plateau.printPlateau();
    }
}
