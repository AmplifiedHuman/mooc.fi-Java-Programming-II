package game;

import java.util.Random;

import gameoflife.GameOfLifeBoard;

public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int[] displacement = {0, 1, -1};
        int livingNeighbours = 0;
        for (int i = 0; i < displacement.length; i++) {
            for (int j = 0; j < displacement.length; j++) {
                if (!(i == 0 && j == 0) && isAlive(x + displacement[i], y + displacement[j])) {
                    livingNeighbours++;
                }
            }
        }
        return livingNeighbours;
    }

    @Override
    public void initiateRandomCells(double prob) {
        Random random = new Random();
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                double generated = random.nextDouble();
                if (generated < prob) {
                    turnToLiving(i, j);
                }
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        return isValidSquare(x, y) && getBoard()[x][y];
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if (livingNeighbours < 2 || livingNeighbours > 3) {
            turnToDead(x, y);
        } else if (livingNeighbours == 3) {
            turnToLiving(x, y);
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        if (isValidSquare(x, y)) {
            getBoard()[x][y] = false;
        }
    }

    @Override
    public void turnToLiving(int x, int y) {
        if (isValidSquare(x, y)) {
            getBoard()[x][y] = true;
        }
    }

    private boolean isValidSquare(int x, int y) {
        return (x >= 0) && (y >= 0) && (x < getWidth()) && (y < getHeight());
    }

}