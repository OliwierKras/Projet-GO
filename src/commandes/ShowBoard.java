package src.commandes;

import src.IHM.*;

public class ShowBoard implements ICommandeGTP {
    private IHM ihm;

    public ShowBoard(IHM ihm) {
        this.ihm = ihm;
    }

    @Override
    public void executer() {
        System.out.println("=");
        System.out.println(ihm.getPlateau().toString());
    }
}
