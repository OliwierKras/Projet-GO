package src.commandes;

import src.IHM.*;

public class ClearBoard implements ICommandeGTP {
    private IHM ihm;

    public ClearBoard(IHM ihm) {
        this.ihm = ihm;
    }

    @Override
    public void executer() {
        ihm.getPlateau().clearPlateau();
        System.out.println("=");
    }
}
