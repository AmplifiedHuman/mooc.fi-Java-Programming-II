package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Copy");
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout grid = new GridLayout(3, 1);

        JTextField field = new JTextField();
        JButton button = new JButton("Copy!");
        JLabel copied = new JLabel();
        ActionEventListener onClick = new ActionEventListener(field, copied);
        button.addActionListener(onClick);
        container.add(field);
        container.add(button);
        container.add(copied);
        container.setLayout(grid);
    }
}
