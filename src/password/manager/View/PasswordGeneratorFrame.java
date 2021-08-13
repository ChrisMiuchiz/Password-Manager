package password.manager.View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import password.manager.Controller.Controller;

public class PasswordGeneratorFrame extends JFrame {
    JTextField password;
    JSpinner lengthSpinner;
    JPanel optionsPanel;
    JCheckBox useNumbersCheckBox;
    JCheckBox useCapsCheckBox;
    JCheckBox useSpecialsCheckBox;
    JButton generateButton;
    Controller controller;
    public PasswordGeneratorFrame(Controller controller) {
        this.controller = controller;
        this.setTitle("Generate password");
        this.setSize(300, 150);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 2));
        
        password = new JTextField(16);
        
        this.add(password, BorderLayout.NORTH);
        
        generateButton = new JButton("Generate");
        this.add(generateButton);
        
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generate();
            }
        });
        
        optionsPanel.add(new JLabel("Password length: "));
        lengthSpinner = new JSpinner(new SpinnerNumberModel(8, 1, 32, 1));
        optionsPanel.add(lengthSpinner);
        
        useNumbersCheckBox = new JCheckBox();
        optionsPanel.add(new JLabel("Use numbers? "));
        optionsPanel.add(useNumbersCheckBox);
        
        useCapsCheckBox = new JCheckBox();
        optionsPanel.add(new JLabel("Use capitals? "));
        optionsPanel.add(useCapsCheckBox);
        
        useSpecialsCheckBox = new JCheckBox();
        optionsPanel.add(new JLabel("Use symbols? "));
        optionsPanel.add(useSpecialsCheckBox);
        
        this.add(optionsPanel, BorderLayout.SOUTH);
    }
    
    public boolean useNumbers() {
        return useNumbersCheckBox.isSelected();
    }
    
    public boolean useCaps() {
        return useCapsCheckBox.isSelected();
    }
    
    public boolean useSpecials() {
        return useSpecialsCheckBox.isSelected();
    }
    
    public int passLength() {
        return (Integer)lengthSpinner.getValue();
    }
    
    public void setPass(String pass) {
        password.setText(pass);
    }
    
    public void generate() {
        controller.passwordGenerate(this);
    }
}
