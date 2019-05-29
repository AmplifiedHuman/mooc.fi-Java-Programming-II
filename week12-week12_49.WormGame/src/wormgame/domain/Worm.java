package wormgame.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import wormgame.Direction;

public class Worm {

    private List<Piece> pieces;
    private Direction direction;
    private boolean grow;

    public Worm(int originalX, int originalY, Direction direction) {
        pieces = new ArrayList<Piece>();
        pieces.add(new Piece(originalX, originalY));
        this.direction = direction;
        grow = false;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction dir) {
        direction = dir;
    }

    public int getLength() {
        return pieces.size();
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void move() {
        int oldX = pieces.get(pieces.size() - 1).getX();
        int oldY = pieces.get(pieces.size() - 1).getY();

        if (direction == Direction.UP) {
            pieces.add(new Piece(oldX, oldY - 1));
        } else if (direction == Direction.DOWN) {
            pieces.add(new Piece(oldX, oldY + 1));
        } else if (direction == Direction.LEFT) {
            pieces.add(new Piece(oldX - 1, oldY));
        } else {
            pieces.add(new Piece(oldX + 1, oldY));
        }

        if (getLength() <= 3 || grow) {
            grow = false;
        } else {
            pieces.remove(0);
        }
    }

    public void grow() {
        grow = true;
    }

    public boolean runsInto(Piece piece) {
        for (Piece eachPiece : pieces) {
            if (eachPiece.runsInto(piece)) {
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself() {
        HashSet<Piece> uniquePieces = new HashSet<Piece>(pieces);
        return uniquePieces.size() != pieces.size();
    }
}