package src.joueurs;

import commandes.GenMove;
import commandes.Play;
import plateau.Plateau;
import IHM.IHM;

public class BotMinimax extends Joueur {
    private int profondeur;

    public BotMinimax(String couleur, int profondeur) {
        super(couleur);
        this.profondeur = profondeur;
    }

    @Override
    public void genMove(IHM ihm) {
        GenMove genMove = new GenMove(ihm, this.getCouleur());
        genMove.setProfondeur(profondeur);
        genMove.executer();
    }
}
