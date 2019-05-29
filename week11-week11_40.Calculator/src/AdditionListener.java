import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class AdditionListener extends Listener implements ActionListener {

    public AdditionListener(Calculator calc, JButton resetButton, JTextField results, JTextField input) {
        super(calc, resetButton, results, input);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (isDigit(getInput().getText())) {
            int digit = Integer.parseInt(getInput().getText());
            getCalculator().add(digit);
            getResults().setText("" + getCalculator().getValue());
        }

        getInput().setText("");
        setResetButton();
    }
}