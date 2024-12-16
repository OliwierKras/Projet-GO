package src.commandes;

import IHM.ICommandeGTP;

public class ProtocolVersion implements ICommandeGTP {
    @Override
    public void executer() {
        System.out.println("= 2");
    }
}
