package src.joueurs;

public class Joueur {
    private String couleur;

    public Joueur(String couleur){
        this.couleur = couleur;
    }


    public String getCouleur() {
        return couleur;
    }

    public char getLettre(){
        return couleur.equals("white") ? 'O' : 'X';
    }
}
