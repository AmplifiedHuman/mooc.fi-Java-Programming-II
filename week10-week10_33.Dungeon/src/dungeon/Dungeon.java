package dungeon;

import java.util.Scanner;

public class Dungeon {

    private Board board;
    private boolean vampiresMove;
    private int moves;
    private Scanner reader;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        board = new Board(length, height, vampires);
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        reader = new Scanner(System.in);
    }

    public void run() {
        board.initializeVampires();
        boolean winStatus = false;
        while (moves > 0 && !winStatus) {
            System.out.println(moves + "\n");
            board.printStats();
            System.out.println("");
            board.printBoard();
            System.out.println("");
            processInput();
            moves--;
            if (board.getVampireCount() == 0) {
                winStatus = true;
            }
        }

        if (winStatus) {
            System.out.println("YOU WIN");
        } else {
            System.out.println("YOU LOSE");
        }
    }

    private void processInput() {
        String move = reader.nextLine();
        board.movePlayer(move);
        if (vampiresMove) {
            board.moveVampires(move.length());
        }
    }

}