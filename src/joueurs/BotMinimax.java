package src.joueurs;

import src.commandes.*;
import src.IHM.IHM;

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
