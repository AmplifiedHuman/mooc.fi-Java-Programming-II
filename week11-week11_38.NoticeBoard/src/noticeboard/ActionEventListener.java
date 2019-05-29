package noticeboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ActionEventListener implements ActionListener {

    private JTextField field;
    private JLabel label;

    public ActionEventListener(JTextField field, JLabel label) {
        this.field = field;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = field.getText();
        field.setText("");
        label.setText(text);
    }

}