package src.IHM;

import java.util.Scanner;
import java.util.List;

public class IHMConsole {

    private Scanner scanner;

    public IHMConsole() {
        this.scanner = new Scanner(System.in);
    }

    public String lireCommande() {
        return scanner.nextLine();
    }
}
