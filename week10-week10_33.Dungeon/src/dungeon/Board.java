package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {

    private final int length;
    private final int height;
    private Sprite[][] board;
    private Player player;
    private List<Vampire> vampires;
    private final int vampireCount;

    public Board(int length, int height, int vampires) {
        this.length = length;
        this.height = height;

        this.vampires = new ArrayList<Vampire>();
        vampireCount = vampires;

        board = new Sprite[height][length];

        player = new Player(0, 0);
        board[0][0] = player;
    }

    // initialise the vampires to a random position on the board
    public void initializeVampires() {
        Random random = new Random();
        for (int i = 0; i < vampireCount; i++) {
            int x;
            int y;
            do {
                x = random.nextInt(length);
                y = random.nextInt(height);
            } while (isOccupiedByVampire(x, y) || (x == 0 && y == 0));
            Vampire vampire = new Vampire(x, y);
            vampires.add(vampire);
            setSquare(x, y, vampire);
        }
    }

    // prints the graphical representation of the board
    public void printBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == null) {
                    System.out.print(".");
                } else if (board[i][j] instanceof Player) {
                    System.out.print("@");
                } else {
                    System.out.print("v");
                }
            }
            System.out.println("");
        }
    }

    // move player according to string sequence
    public void movePlayer(String direction) {
        for (int i = 0; i < direction.length(); i++) {
            movePlayer(direction.charAt(i));
        }
    }

    // move player according to a single char
    public void movePlayer(char move) {

        int newX = player.getX();
        int newY = player.getY();

        // used switch statement to determine the displacement of player
        switch (move) {
        case 'w':
            newY--;
            break;
        case 'a':
            newX--;
            break;
        case 's':
            newY++;
            break;
        case 'd':
            newX++;
            break;
        }

        // if the square is not valid or the command is unknown return to caller
        if (!isSquareValid(newX, newY) || (newX == player.getX() && newY == player.getY())) {
            return;
        }

        // if the square is occupied by a vampire, kill it and remove it from the list
        clearSquare(player.getX(), player.getY());
        player.moveTo(newX, newY);

        if (isOccupiedByVampire(newX, newY)) {
            Vampire killedVampire = (Vampire) replaceSquare(newX, newY, player);
            vampires.remove(killedVampire);
        } else {
            setSquare(newX, newY, player);
        }
    }

    // move vampires by one move
    public void moveVampire() {
        final String moves = "wasd";
        Random random = new Random();
        ArrayList<Vampire> removed = new ArrayList<Vampire>();

        for (Vampire vampire : vampires) {
            int newX = vampire.getX();
            int newY = vampire.getY();
            char randomMove = moves.charAt(random.nextInt(moves.length()));
            switch (randomMove) {
            case 'w':
                newY--;
                break;
            case 'a':
                newX--;
                break;
            case 's':
                newY++;
                break;
            case 'd':
                newX++;
                break;
            }
            if (isSquareValid(newX, newY) && !isOccupiedByVampire(newX, newY)) {
                clearSquare(vampire.getX(), vampire.getY());
                if (isOccupiedByPlayer(newX, newY)) {
                    removed.add(vampire);
                } else {
                    vampire.moveTo(newX, newY);
                    setSquare(newX, newY, vampire);
                }
            }
        }
        vampires.removeAll(removed);
    }

    // move Vampire n times
    public void moveVampires(int n) {
        for (int i = 0; i < n; i++) {
            moveVampire();
        }
    }

    // prints the status of the sprites
    public void printStats() {
        System.out.println(player);
        for (Vampire vampire : vampires) {
            System.out.println(vampire);
        }
    }

    public int getVampireCount() {
        return vampires.size();
    }

    // check if a square is occupied by another vampire
    private boolean isOccupiedByVampire(int x, int y) {
        if (board[y][x] == null || board[y][x] == player) {
            return false;
        }
        return true;
    }

    private boolean isOccupiedByPlayer(int x, int y) {
        return board[y][x] == player;
    }

    // set a square to new sprite
    private void setSquare(int x, int y, Sprite sprite) {
        board[y][x] = sprite;
    }

    // set a square to new sprite and return the old sprite
    private Sprite replaceSquare(int x, int y, Sprite newSprite) {
        Sprite oldSprite = board[y][x];
        board[y][x] = newSprite;
        return oldSprite;
    }

    // clear a square in the board
    private void clearSquare(int x, int y) {
        board[y][x] = null;
    }

    // checks if a square is valid
    private boolean isSquareValid(int x, int y) {
        return (x >= 0) && (y >= 0) && (x <= (length - 1)) && (y <= (height - 1));
    }
}