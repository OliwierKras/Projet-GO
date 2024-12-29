package src.commandes;

import src.IHM.ICommandeGTP;
import src.IHM.*;
import src.joueurs.*;

public class SetPlayer implements ICommandeGTP {
    private IHM ihm;
    private String couleur;
    private String typeJoueur;
    private int profondeur;

    public SetPlayer(IHM ihm, String couleur, String typeJoueur) {
        this.ihm = ihm;
        this.couleur = couleur;
        this.typeJoueur = typeJoueur;
        this.profondeur = 0;
    }

    public SetPlayer(IHM ihm, String couleur, String typeJoueur, String profondeur) {
        this.ihm = ihm;
        this.couleur = couleur;
        this.typeJoueur = typeJoueur;
        this.profondeur =  Integer.parseInt(profondeur);
    }


    @Override
    public void executer() {
        IJoueur joueur = null;
        if(typeJoueur.equals("human")){
            joueur = new Humain(couleur);
        } else if (typeJoueur.equals("randomBot")) {
            joueur = new BotNaif(couleur);
        }else if(typeJoueur.equals("minimax")){
            joueur = new BotMinimax(couleur, profondeur);
        }

        if (couleur.equals("black")) {
            ihm.setJoueurNoir(joueur);
        }else{
            ihm.setJoueurBlanc(joueur);
        }
        System.out.println("=");
    }
}
