package src.joueurs;

import src.commandes.*;
import src.IHM.IHM;

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
        System.out.println("Coup du bot: ");
        List<String> coupsPossibles = ihm.getPlateau().getCoupsPossibles();
        String coup = coupsPossibles.get(random.nextInt(coupsPossibles.size()));
        new Play(ihm, this.getCouleur(), coup).executer();
        System.out.println(coup);
    }
}
