package clicker.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import clicker.applicationlogic.Calculator;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calculator;

    public UserInterface(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(650, 650));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BorderLayout border = new BorderLayout();
        container.setLayout(border);
        JLabel label = new JLabel("0");
        JButton button = new JButton("Click!");
        button.addActionListener(new ClickListener(calculator, label));
        container.add(label, BorderLayout.NORTH);
        container.add(button, BorderLayout.CENTER);
    }

    public JFrame getFrame() {
        return frame;
    }
}
