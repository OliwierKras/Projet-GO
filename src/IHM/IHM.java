package src.IHM;

import src.commandes.*;
import src.plateau.Plateau;

public class IHM {
    private Plateau plateau;
    private IJoueur joueurNoir;
    private IJoueur joueurBlanc;
    private IHMConsole ihm;

    public IHM() {
        this.ihm = new IHMConsole();
        this.plateau = new Plateau();
        this.joueurNoir = null;
        this.joueurBlanc = null;
    }

    public void debug() {
        while (true) {
            String commande = ihm.lireCommande();
            ICommandeGTP commandeGTP = CommandeFactory.creer(this, commande);
            commandeGTP.executer();
            System.out.println();
        }
    }

    public void partie(){
        System.out.println("Veuillez définir les joueurs (black et white)");
        String setPlayer1 = ihm.lireCommande();
        ICommandeGTP commandeGTP = CommandeFactory.creer(this, setPlayer1);
        commandeGTP.executer();
        String setPlayer2 = ihm.lireCommande();
        commandeGTP = CommandeFactory.creer(this, setPlayer2);
        commandeGTP.executer();

        while (!this.plateau.verifierVictoire(joueurNoir.getSymbole())
                && !this.plateau.verifierVictoire(joueurBlanc.getSymbole()))
        {
            new ShowBoard(this).executer();
            joueurNoir.genMove(this);
            joueurBlanc.genMove(this);
        }
        new ShowBoard(this).executer();
    }

    public void setJoueurNoir(IJoueur joueur){
        this.joueurNoir = joueur;
    }

    public void setJoueurBlanc(IJoueur joueur){
        this.joueurBlanc = joueur;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public IJoueur getJoueurParCouleur(String couleur) {
        return couleur.equals("black") ? joueurNoir : joueurBlanc;
    }
}
