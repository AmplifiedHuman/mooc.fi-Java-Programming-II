package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        drawContent(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void drawContent(Container container) {
        BoxLayout box = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(box);
        container.add(new JLabel("Are you?"));
        JCheckBox yesButton = new JCheckBox("Yes!");
        JCheckBox noButton = new JCheckBox("No!");
        container.add(yesButton);
        container.add(noButton);

        container.add(new JLabel("Why?"));
        JRadioButton noReasonButton = new JRadioButton("No reason.");
        JRadioButton funButton = new JRadioButton("Because it is fun!");
        ButtonGroup group = new ButtonGroup();
        group.add(noReasonButton);
        group.add(funButton);
        container.add(noReasonButton);
        container.add(funButton);
        container.add(new JButton("Done!"));
    }


    public JFrame getFrame() {
        return frame;
    }
}
