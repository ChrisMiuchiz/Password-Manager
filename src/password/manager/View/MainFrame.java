package password.manager.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import password.manager.Controller.Controller;

public class MainFrame extends JFrame {
    private final Controller controller;
    private ServiceListPanel serviceList;
    
    public MainFrame(Controller controller) {
        this.controller = controller;
        this.initialize();
    }
    
    private void initialize() {
        serviceList = new ServiceListPanel();
        serviceList.setPreferredSize(new Dimension(250, 600));
        this.add(serviceList, BorderLayout.WEST);
        
        this.setTitle("Password Manager");
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        
    }
}
