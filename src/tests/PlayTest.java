package src.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.commandes.Play;
import src.IHM.IHM;
import src.plateau.Plateau;

import static org.junit.jupiter.api.Assertions.*;

public class PlayTest {

    private IHM ihm;
    private Plateau plateau;

    @BeforeEach
    void setUp() {
        ihm = new IHM();
    }

    @Test
    void testExecuterAucunCoup() {
        Play play = new Play(ihm, "white", null);

        play.executer();

        assertTrue(ihm.getPlateau().getCoupsPossibles().size() == 36, "Le coup n'a pas été appliqué car la position est null");
    }

    @Test
    void testExecuterCoupIllegal() {
        Play play = new Play(ihm, "black", "A6");

        play.executer();

        assertTrue(ihm.getPlateau().getCoupsPossibles().size() == 35, "Le coup n'a pas été appliqué car il est illégal");
    }

    @Test
    void testExecuterCoupLegal() {
        Play play = new Play(ihm, "white", "B3");

        play.executer();

        assertEquals('O', ihm.getPlateau().getGrille()[3][1], "Le coup appliqué par 'blanc' sur B3 doit placer un 'O'");
    }

    @Test
    void testExecuterCoordonneesIncorrectes() {
        Play play = new Play(ihm, "white", "Z9");  // Position invalide (hors du plateau)

        play.executer();

        assertTrue(ihm.getPlateau().getCoupsPossibles().size() == 36, "La grille ne doit pas changer si la position est invalide");
    }

    @Test
    void testExecuterCoordonneesValides() {
        Play play = new Play(ihm, "black", "C2");  // Position valide

        play.executer();

        int ligneAttendue = 4;
        int colonneAttendue = 2;
        assertEquals('X', ihm.getPlateau().getGrille()[ligneAttendue][colonneAttendue], "Le coup appliqué par 'noir' sur C2 doit placer un 'X'");
    }
}
