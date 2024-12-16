package src.joueurs;

import commandes.GenMove;
import IHM.IHM;
import commandes.Play;

import java.util.List;
import java.util.Random;

public class BotNaif extends Joueur{
    private Random random;

    public BotNaif(String couleur) {
        super(couleur);
        random = new Random();
    }

    @Override
    public void genMove(IHM ihm) {
        List<String> coupsPossibles = ihm.getPlateau().getCoupsPossibles();
        String coup = coupsPossibles.get(random.nextInt(coupsPossibles.size()));
        new Play(ihm, this.getCouleur(), coup).executer();
    }
}
