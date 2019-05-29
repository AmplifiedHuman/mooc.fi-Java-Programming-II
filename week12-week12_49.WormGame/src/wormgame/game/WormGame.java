package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Worm worm;
    private Apple apple;
    private Updatable updatable;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
        worm = new Worm(width / 2, height / 2, Direction.DOWN);
        apple = generateApple();
        addActionListener(this);
        setInitialDelay(2000);

    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
        worm.move();
        if (worm.runsInto(apple)) {
            setApple(generateApple());
            worm.grow();
        }
        if (worm.runsIntoItself()) {
            continues = false;
        }

        for (Piece piece : worm.getPieces()) {
            if (piece.getX() == width || piece.getY() == height || piece.getX() == 0 || piece.getY() == 0) {
                continues = false;
            }
        }
        updatable.update();
        setDelay(1000 / worm.getLength());
    }

    private Apple generateApple() {
        Apple temp;
        do {
            temp = new Apple(new Random().nextInt(width), new Random().nextInt(height));
        } while (worm.runsInto(temp));
        return temp;
    }

}
