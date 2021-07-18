package password.manager.View;

import javax.swing.JOptionPane;

public class YesNoDialog {
    public YesNoDialog() {
    }
    
    public boolean prompt(String title, String message) {
        int result = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        return result == JOptionPane.YES_OPTION;
    }
}
