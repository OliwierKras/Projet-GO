package src.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import src.joueurs.Joueur;
import src.plateaux.Plateau;

public class PlateauTest {
    Plateau plateau = new Plateau(7);
    @Test
    public void testTaillePlateau(){
        assertEquals(7, plateau.getTaille());
    }

    @Test
    public void testPlacerPion(){
        Joueur joueurNoir = new Joueur("black");

        plateau.placerPion(joueurNoir, 'A', 7);
        assertEquals(plateau.getPlacement(joueurNoir)[0], 0);
        assertEquals(plateau.getPlacement(joueurNoir)[1], 0);

    }

    @Test
    public void testClearPlateau(){
        for(int i = 0; i < plateau.getTaille(); ++i){
            for(int j = 0; j < plateau.getTaille(); ++j){
                assertEquals(Plateau.VIDE, plateau.getGrille()[i][j]);
            }
        }
    }

}
