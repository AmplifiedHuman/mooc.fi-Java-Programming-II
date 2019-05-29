package dungeon;

public class Player extends Sprite {

    public Player(int x, int y) {
        super(x, y);
    }

    @Override 
    public String toString() {
        //@ 1 2
        return "@" + " " + getX() + " " + getY();
    }
}