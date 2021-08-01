package password.manager.View;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class SetMasterPasswordFrame {
    private final JPanel panel;
    private final JLabel label;
    private final JPasswordField passwordField;
    private final String[] options;
    public SetMasterPasswordFrame() {
        panel = new JPanel();
        label = new JLabel("Set your master password:");
        passwordField = new JPasswordField(16);
        panel.add(label);
        panel.add(passwordField);
        options = new String[]{"OK"};
        
    }
    
    public String promptPassword() {
        JOptionPane.showOptionDialog(
                null, panel, "Password",
                JOptionPane.NO_OPTION, 
                JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
        return new String(passwordField.getPassword());
    }
}
