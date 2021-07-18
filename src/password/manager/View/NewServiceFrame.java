package password.manager.View;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewServiceFrame {
    private final JPanel panel;
    private final JLabel label;
    private final JTextField serviceField;
    private final String[] options;
    public NewServiceFrame() {
        panel = new JPanel();
        label = new JLabel("Name of new service: ");
        serviceField = new JTextField(16);
        panel.add(label);
        panel.add(serviceField);
        options = new String[]{"OK", "Cancel"};
    }
    
    public String promptServiceName() {
        int option = JOptionPane.showOptionDialog(
                null, panel, "New service",
                JOptionPane.NO_OPTION, 
                JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
        
        if (option == 0) {
            return serviceField.getText();
        }
        else {
            return null;
        }
        
    }
}
