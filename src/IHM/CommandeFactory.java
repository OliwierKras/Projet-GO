package src.IHM;

import src.commandes.*;

public class CommandeFactory {
    public static String[] commandes =
            {
                    "play",
                    "boardsize",
                    "showboard",
                    "genmove",
                    "clear_board",
                    "name",
                    "protocol_version",
                    "version",
                    "quit"
            };
    public static ICommandeGTP creer(IHM ihm, String entree) {
        String[] args = entree.split(" ");
        String commande = args[0];

        switch (commande) {
            case "play": return new Play(ihm, args[1], args[2]);
            case "boardsize": return new BoardSize(ihm, Integer.parseInt(args[1]));
            case "showboard" : return new ShowBoard(ihm);
            case "genmove": return new GenMove(ihm, args[1]);
            case "clear_board": return new ClearBoard(ihm);
            case "name": return new Name();
            case "protocol_version": return new ProtocolVersion();
            case "version": return new Version();
            case "list_commands": return new ListCommands(commandes);
            case "set_player":
                if (args.length == 3) {
                    // Si on a 3 arguments, on crée le joueur sans profondeur
                    return new SetPlayer(ihm, args[1], args[2]);
                } else if (args.length == 4) {
                    // Si on a 4 arguments, on crée un joueur avec profondeur
                    return new SetPlayer(ihm, args[1], args[2], args[3]);
                } else {
                    throw new IllegalArgumentException("Le nombre d'arguments pour set_player est incorrect.");
                }

            case "quit": return new Quit();
            default:  return new UnknownCommand(commande);
        }
    }
}
