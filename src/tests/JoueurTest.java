package src.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import src.joueurs.Joueur;
import org.junit.jupiter.api.Test;
import src.joueurs.Joueur;
import src.partie.Plateau;

public class JoueurTest {
    @Test
    public void testJouer(){
        Plateau plateau = new Plateau();
        Joueur joueurNoir = new Joueur("black", plateau);
        Joueur joueurBlanc = new Joueur("white", plateau);

        joueurNoir.jouer('A', 7);

        assertEquals(plateau.getPlacement(joueurNoir)[0], 0);
        assertEquals(plateau.getPlacement(joueurNoir)[1], 0);

        joueurBlanc.jouer('B', 5);
        joueurNoir.jouer('B', 5);

        assertEquals(plateau.getPlacement(joueurBlanc)[0], 2);
        assertEquals(plateau.getPlacement(joueurBlanc)[1], 1);

        assertEquals(plateau.getPlacement(joueurNoir)[0], 0);
        assertEquals(plateau.getPlacement(joueurNoir)[1], 0);
    }
}
