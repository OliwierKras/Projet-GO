package src.jeu;

import src.joueurs.Joueur;
import src.plateaux.Plateau;

import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.in;

public class Partie {
    private Plateau plateau;
    private Joueur joueurNoir;
    private Joueur joueurBlanc;
    private Scanner sc;

    public Partie(){
        plateau = new Plateau();
        joueurNoir = new Joueur("black");
        joueurBlanc = new Joueur("white");
        sc = new Scanner(in);
    }

    public void session(){
        String entree = sc.nextLine();
        while(true){
            this.lancerCommande(entree);
            entree = sc.nextLine();
        }
    }

    public void jouerTour(Joueur joueur, char colonne, int ligne){
        plateau.placerPion(joueur, colonne, ligne);
    }
    public void randJouerTour(Joueur joueur){
        plateau.genMove(joueur);
    }

    public void lancerCommande(String entree){
        String[] entreeToArray = entree.split(" ");
        String commande = entreeToArray[0];

        switch (commande){
            case "boardsize": plateau.setTaille(Integer.parseInt(entreeToArray[1]));
            break;

            case "clear_board": plateau.clearPlateau();
            break;

            case "show_board": plateau.printPlateau();
            break;

            case "gen_move":
                if (entreeToArray.length != 2){
                    System.out.print("");
                }else{
                    String couleurJoueur = entreeToArray[1];
                    if (couleurJoueur.equals(joueurNoir.getCouleur())){
                        randJouerTour(joueurNoir);
                    }else if(couleurJoueur.equals(joueurBlanc.getCouleur())){
                        randJouerTour(joueurBlanc);
                    }else{
                        System.out.println("Couleur invalide");
                    }
                    break;
                }


            case "play":
                if (entreeToArray.length != 3){
                    System.out.println("La commande est invalide");
                }else {
                    String couleur = entreeToArray[1];
                    String position = entreeToArray[2];
                    char[] positionToArray = position.toCharArray();
                    if (couleur.equals(joueurNoir.getCouleur())){
                        jouerTour(joueurNoir, positionToArray[0], Character.getNumericValue(positionToArray[1]));
                    }else if(couleur.equals(joueurBlanc.getCouleur())){
                        jouerTour(joueurBlanc, positionToArray[0], Character.getNumericValue(positionToArray[1]));
                    }else{
                        System.out.println("Couleur invalide");
                    }
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
