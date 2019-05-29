import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ResetListener extends Listener implements ActionListener {

    public ResetListener(Calculator calc, JButton resetButton, JTextField results, JTextField input) {
        super(calc, resetButton, results, input);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getCalculator().reset();
        getResults().setText("0");
        getInput().setText("");
        setResetButton();
    }
}