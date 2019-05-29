import javax.swing.JButton;
import javax.swing.JTextField;

public class Listener {
    private Calculator calc;
    private JButton resetButton;
    private JTextField results;
    private JTextField input;

    public Listener(Calculator calc, JButton resetButton, JTextField results, JTextField input) {
        this.calc = calc;
        this.resetButton = resetButton;
        this.results = results;
        this.input = input;
    }

    public Calculator getCalculator() {
        return calc;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JTextField getResults() {
        return results;
    }

    public JTextField getInput() {
        return input;
    }

    public boolean isDigit(String word) {
        try {
            Integer.parseInt(word);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setResetButton() {
        if (results.getText().equals("0")) {
            resetButton.setEnabled(false);
        } else {
            resetButton.setEnabled(true);
        }
    }
}