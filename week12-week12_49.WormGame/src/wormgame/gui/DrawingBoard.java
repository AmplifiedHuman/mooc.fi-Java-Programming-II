package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import wormgame.domain.Apple;
import wormgame.domain.Piece;

import wormgame.game.WormGame;

public class DrawingBoard extends JPanel implements Updatable {

    private WormGame wormGame;
    private int pieceLength;

    public DrawingBoard(WormGame wormGame, int pieceLength) {
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (Piece piece : wormGame.getWorm().getPieces()) {
            g.fill3DRect(piece.getX() * pieceLength, piece.getY() * pieceLength, pieceLength, pieceLength, true);
        }
        g.setColor(Color.RED);
        Apple apple = wormGame.getApple();
        g.fillOval(apple.getX() * pieceLength, apple.getY() * pieceLength, pieceLength, pieceLength);
    }

    @Override
    public void update() {
        repaint();
    }
}