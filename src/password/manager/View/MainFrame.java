package password.manager.View;

import javax.swing.JFrame;
import password.manager.Controller.Controller;

public class MainFrame extends JFrame {
    private final Controller controller;
    
    public MainFrame(Controller controller) {
        this.controller = controller;
        this.initialize();
    }
    
    private void initialize() {
        this.setTitle("Password Manager");
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}
