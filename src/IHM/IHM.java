package src.IHM;

import src.commandes.*;
import src.plateau.Plateau;

import java.util.Scanner;

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

    public void choisirMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez le mode de jeu  (Tapez 1 ou 2) : ");
        System.out.println("1 - Mode Partie");
        System.out.println("2 - Mode Debug");
        String choix = scanner.nextLine();

        switch (choix) {
            case "1":
                partie();
                break;
            case "2":
                debug();
                break;
            default:
                System.out.println("Choix invalide, veuillez réessayer.");
                choisirMode();
                break;
        }
    }

    public void debug() {
        while (true) {
            String commande = ihm.lireCommande();
            ICommandeGTP commandeGTP = CommandeFactory.creer(this, commande);
            commandeGTP.executer();
            System.out.println();
        }
    }

    public void partie() {
        System.out.println("Veuillez choisir la taille du plateau:");
        int taillePlateau = 0;
        taillePlateau = Integer.parseInt(ihm.lireCommande());
        plateau.setTaille(taillePlateau); 

        System.out.println("Veuillez définir le premier joueur (set_player [couleur] [human/randomBot/minimax] [?profondeur])");
        String setPlayer1 = ihm.lireCommande();
        ICommandeGTP commandeGTP = CommandeFactory.creer(this, setPlayer1);
        commandeGTP.executer();
        System.out.println("Veuillez définir le deuxieme joueur (set_player [couleur] [human/randomBot/minimax] [?profondeur])");
        String setPlayer2 = ihm.lireCommande();
        commandeGTP = CommandeFactory.creer(this, setPlayer2);
        commandeGTP.executer();

        while (!this.plateau.verifierVictoire(joueurNoir.getSymbole())
                && !this.plateau.verifierVictoire(joueurBlanc.getSymbole())
                && !this.plateau.estPlein())
        {
            new ShowBoard(this).executer();
            joueurNoir.genMove(this);
            joueurBlanc.genMove(this);
        }
        new ShowBoard(this).executer();
        if(this.plateau.estPlein()){
            System.out.println("Egalité");
        }else if(this.plateau.verifierVictoire(joueurNoir.getSymbole())){
            System.out.println("Vainqueur: "+joueurNoir.getCouleur());
        }else{
            System.out.println("Vainqueur: "+joueurBlanc.getCouleur());
        }
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
}
