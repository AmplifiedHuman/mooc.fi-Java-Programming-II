
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {
    private JFrame frame;
    private Calculator calc;

    public GraphicCalculator(Calculator calc) {
        this.calc = calc;
    }

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout grid = new GridLayout(3, 1);
        container.setLayout(grid);
        JTextField results = new JTextField("0");
        results.setEnabled(false);
        JTextField input = new JTextField();
        JPanel bottomBar = bottomBar(results, input);

        container.add(results);
        container.add(input);
        container.add(bottomBar);

    }

    public JFrame getFrame() {
        return frame;
    }

    private JPanel bottomBar(JTextField results, JTextField input) {
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(1, 3);
        panel.setLayout(grid);
        JButton add = new JButton("+");
        JButton subtract = new JButton("-");
        JButton clear = new JButton("Z");

        add.addActionListener(new AdditionListener(calc, clear, results, input));
        subtract.addActionListener(new SubtractionListener(calc, clear, results, input));
        clear.addActionListener(new ResetListener(calc, clear, results, input));
        clear.setEnabled(false);

        panel.add(add);
        panel.add(subtract);
        panel.add(clear);
        return panel;
    }
}
