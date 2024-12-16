package src.commandes;

import src.IHM.ICommandeGTP;

public class Name implements ICommandeGTP {
    @Override
    public void executer() {
        System.out.println("= "+System.getProperty("sun.java.command"));
    }
}
