package src.IHM;

import java.util.Scanner;
import java.util.List;

public class IHMConsole {

    private Scanner scanner;

    public IHMConsole() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Lit une commande depuis la console.
     * @return La commande entrée par l'utilisateur.
     */
    public String lireCommande() {
        return scanner.nextLine();
    }
}
