package src.commandes;

import src.IHM.ICommandeGTP;

import static java.lang.System.exit;

public class Quit implements ICommandeGTP {
    @Override
    public void executer() {
        System.out.println("=");
        exit(0);
    }
}
