package password.manager.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ServiceInfoPanel extends JPanel {
    private JTextField serviceNameField;
    private JTextField serviceUsernameField;
    private JTextField servicePasswordField;
    private JTextArea serviceNotesField;
    
    private JPanel notesPanel;
    private JPanel credsPanel;
    
    JButton saveButton;
    public ServiceInfoPanel() {
        serviceNameField = new JTextField(15);
        serviceUsernameField = new JTextField(15);
        servicePasswordField = new JTextField(15);
        serviceNotesField = new JTextArea(25, 50);
        
        Border border = BorderFactory.createLineBorder(Color.GRAY);
        serviceNotesField.setBorder(BorderFactory.createCompoundBorder(border,
            BorderFactory.createEmptyBorder(1,1,1,1)));
        
        
        notesPanel = new JPanel();
        notesPanel.add(serviceNotesField);
        
        credsPanel = new JPanel();
        credsPanel.setLayout(new GridLayout(3, 2));
        credsPanel.setPreferredSize(new Dimension(550, 80));
        
        credsPanel.add(new JLabel("Service name"));
        credsPanel.add(serviceNameField);
        credsPanel.add(new JLabel("Username"));
        credsPanel.add(serviceUsernameField);
        credsPanel.add(new JLabel("Password"));
        credsPanel.add(servicePasswordField);
        
        saveButton = new JButton("Save");
        
        this.add(credsPanel, BorderLayout.NORTH);
        this.add(notesPanel, BorderLayout.SOUTH);
        
        this.add(saveButton);
    }
}
