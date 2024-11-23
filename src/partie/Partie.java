package src.partie;

import src.joueurs.Joueur;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.in;

public class Partie {
    private static final int DEFAULT_TAILLE_PLATEAU = 7;
    private Plateau plateau;
    private Joueur joueurNoir;
    private Joueur joueurBlanc;
    private Scanner sc;

    public Partie(){
        plateau = new Plateau(DEFAULT_TAILLE_PLATEAU);
        joueurNoir = new Joueur("black", plateau);
        joueurBlanc = new Joueur("white", plateau);
        sc = new Scanner(in);
    }

    public void session(){
        String entree = sc.nextLine();
        while(true){
            this.lancerCommande(entree);
            entree = sc.nextLine();
        }
    }

    public void lancerCommande(String entree){
        String[] entreeToArray = entree.split(" ");
        String commande = entreeToArray[0];

        switch (commande){
            case "boardsize": plateau.setBoardSize(Integer.parseInt(entreeToArray[1]));
            break;

            case "clear_board": plateau.clearPlateau();
            break;

            case "show_board": plateau.printPlateau();
            break;

            case "play":
                String couleur = entreeToArray[1];
                String position = entreeToArray[2];
                char[] positionToArray = position.toCharArray();
                if (couleur.equals(joueurNoir.getCouleur())){
                    joueurNoir.placerPion(positionToArray[0], Character.getNumericValue(positionToArray[1]));
                }else{
                    joueurBlanc.placerPion(positionToArray[0], Character.getNumericValue(positionToArray[1]));
                }
            break;

            case "quit": exit(0);
            break;

            default: System.out.println("La commande est invalide"); break;
        }
    }

    public Plateau getPlateau(){
        return plateau;
    }

    public Joueur getJoueurNoir(){
        return  joueurNoir;
    }

    public Joueur getJoueurBlanc(){
        return  joueurBlanc;
    }

}
