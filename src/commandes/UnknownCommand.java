package src.commandes;

import IHM.ICommandeGTP;

public class UnknownCommand implements ICommandeGTP {
    private String commande;

    public UnknownCommand(String commande) {
        this.commande = commande;
    }

    @Override
    public void executer() {
        System.out.println("? unknown command: "+ commande);
    }
}
