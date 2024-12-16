package src.commandes;

import IHM.ICommandeGTP;

import java.util.*;

public class ListCommands implements ICommandeGTP {
    private List<String> commandes;
    public ListCommands(String[] commandes){
        this.commandes = new ArrayList<>(Arrays.asList(commandes));
    }
    @Override
    public void executer() {
        boolean premier = true;
        Collections.sort(commandes);
        for(String commande : commandes){
            if (premier) {
                System.out.println("= "+commande);
                premier = false;
            }else
                System.out.println(commande);
        }
    }
}
