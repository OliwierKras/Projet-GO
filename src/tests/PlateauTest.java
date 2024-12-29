package src.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.plateau.Plateau;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlateauTest {
    private Plateau plateau;

    @BeforeEach
    void setUp() {
        plateau = new Plateau();
    }

    @Test
    void testInitialiserPlateau() {
        char[][] grille = plateau.getGrille();
        for (char[] ligne : grille) {
            for (char caseVide : ligne) {
                assertEquals(Plateau.VIDE, caseVide, "La grille doit être initialisée avec des cases vides.");
            }
        }
    }

    @Test
    void testCoupPossible() {
        assertTrue(plateau.coupPossible(0, 0), "Un coup sur une case vide doit être possible.");
        plateau.appliquerCoup("A6", "white");
        assertFalse(plateau.coupPossible(0, 0), "Un coup sur une case occupée ne doit pas être possible.");
    }

    @Test
    void testAppliquerCoup() {
        plateau.appliquerCoup("A6", "white");
        assertEquals('O', plateau.getGrille()[0][0], "Le coup appliqué par 'white' doit placer un 'O'.");
        plateau.appliquerCoup("B6", "black");
        assertEquals('X', plateau.getGrille()[0][1], "Le coup appliqué par 'black' doit placer un 'X'.");
    }

    @Test
    void testAppliquerCoupException() {
        plateau.appliquerCoup("A6", "white");
        assertThrows(IllegalArgumentException.class, () -> plateau.appliquerCoup("A6", "black"),
                "Un coup sur une case déjà occupée doit lever une exception.");
    }

    @Test
    void testGetCoupsPossibles() {
        List<String> coups = plateau.getCoupsPossibles();
        assertEquals(36, coups.size(), "Sur un plateau 6x6 vide, il doit y avoir 36 coups possibles.");
        plateau.appliquerCoup("A6", "white");
        coups = plateau.getCoupsPossibles();
        assertEquals(35, coups.size(), "Après un coup, il doit rester 35 coups possibles.");
        assertFalse(coups.contains("A6"), "Le coup déjà joué ne doit pas être dans la liste des coups possibles.");
    }

    @Test
    void testVerifierVictoireHorizontal() {
        plateau.appliquerCoup("A6", "white");
        plateau.appliquerCoup("B6", "white");
        plateau.appliquerCoup("C6", "white");
        plateau.appliquerCoup("D6", "white");
        plateau.appliquerCoup("E6", "white");
        assertTrue(plateau.verifierVictoire('O'), "Cinq 'O' alignés horizontalement doivent être une victoire.");
    }

    @Test
    void testVerifierVictoireVertical() {
        plateau.appliquerCoup("A6", "white");
        plateau.appliquerCoup("A5", "white");
        plateau.appliquerCoup("A4", "white");
        plateau.appliquerCoup("A3", "white");
        plateau.appliquerCoup("A2", "white");
        assertTrue(plateau.verifierVictoire('O'), "Cinq 'O' alignés verticalement doivent être une victoire.");
    }

    @Test
    void testVerifierVictoireDiagonaleDescendante() {
        plateau.appliquerCoup("A6", "white");
        plateau.appliquerCoup("B5", "white");
        plateau.appliquerCoup("C4", "white");
        plateau.appliquerCoup("D3", "white");
        plateau.appliquerCoup("E2", "white");
        assertTrue(plateau.verifierVictoire('O'), "Cinq 'O' alignés en diagonale descendante doivent être une victoire.");
    }

    @Test
    void testVerifierVictoireDiagonaleMontante() {
        plateau.appliquerCoup("E6", "white");
        plateau.appliquerCoup("D5", "white");
        plateau.appliquerCoup("C4", "white");
        plateau.appliquerCoup("B3", "white");
        plateau.appliquerCoup("A2", "white");
        assertTrue(plateau.verifierVictoire('O'), "Cinq 'O' alignés en diagonale montante doivent être une victoire.");
    }

    @Test
    void testEstPlein() {
        assertFalse(plateau.estPlein(), "Un plateau vide ne doit pas être plein.");
        for (String coup : plateau.getCoupsPossibles()) {
            plateau.appliquerCoup(coup, "white");
        }
        assertTrue(plateau.estPlein(), "Un plateau complètement rempli doit être plein.");
    }

    @Test
    void testSetGrilleEtGetGrille() {
        char[][] nouvelleGrille = new char[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                nouvelleGrille[i][j] = Plateau.VIDE;
            }
        }
        nouvelleGrille[0][0] = 'O';
        plateau.setGrille(nouvelleGrille);
        assertEquals('O', plateau.getGrille()[0][0], "La méthode setGrille doit correctement modifier la grille.");
    }

    @Test
    void testSetTaille() {
        plateau.setTaille(8);
        assertEquals(8, plateau.getTaille(), "La taille du plateau doit être mise à jour.");
        assertEquals(64, plateau.getCoupsPossibles().size(), "Un plateau 8x8 vide doit avoir 64 coups possibles.");
    }
}
