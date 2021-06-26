package password.manager.View;

import javax.swing.JFrame;
import password.manager.Controller.Controller;

public class MainFrame extends JFrame {
    private final Controller controller;
    public MainFrame(Controller controller) {
        this.controller = controller;
    }
}
