package drawing.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingBoard extends JPanel {

    public DrawingBoard() {
        super.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        int eyeDistance = 100;
        int squareSide = 53;
        graphics.fillRect(200 - eyeDistance/2 - squareSide, 45, squareSide, squareSide);
        graphics.fillRect(200 + eyeDistance/2, 45, squareSide, squareSide);
        int eyeMouthGap = 140;
        graphics.fillRect(200 - eyeDistance/2 - 2 * squareSide, squareSide + eyeMouthGap, squareSide, squareSide);
        graphics.fillRect(200 - eyeDistance/2 - squareSide, 2 * squareSide + eyeMouthGap, 2 * squareSide + eyeDistance, squareSide);
        graphics.fillRect(200 + eyeDistance/2 + squareSide, squareSide + eyeMouthGap, squareSide, squareSide);

    }
}
