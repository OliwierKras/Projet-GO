package plateau;

public class Plateau {
    private int boardSize;
    private char [][] plateau;

    public Plateau(int boardSize) {
        if (boardSize <= 0) {
            throw new IllegalArgumentException("La taille du plateau doit être positive");
        }
        this.boardSize = boardSize;
        plateau = new char[boardSize][boardSize];
        initialiserPlateau(boardSize);
    }

    public void initialiserPlateau(int boardSize) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                plateau[i][j] = '.';
            }
        }
    }

    public char[][] getPlateau() {
        return plateau;
    }

    public int getBoardSize(){
        return boardSize;
    }

    public void clearPlateau(){
        initialiserPlateau(boardSize);
    }
    public void printPlateau(){
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
