package src.commandes;

import src.IHM.ICommandeGTP;

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
