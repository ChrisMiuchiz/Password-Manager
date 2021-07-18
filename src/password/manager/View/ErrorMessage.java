package password.manager.View;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorMessage {
    public ErrorMessage(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
    }
        
}
