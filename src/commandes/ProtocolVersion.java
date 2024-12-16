package src.commandes;

import src.IHM.ICommandeGTP;

public class ProtocolVersion implements ICommandeGTP {
    @Override
    public void executer() {
        System.out.println("= 2");
    }
}
