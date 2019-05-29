package dungeon;

public class Vampire extends Sprite {

    public Vampire(int x, int y) {
        super(x, y);
    }
    
    @Override 
    public String toString() {
        //v 1 2
        return "v" + " " + getX() + " " + getY();
    }
}