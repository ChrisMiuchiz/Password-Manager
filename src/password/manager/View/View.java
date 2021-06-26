package password.manager.View;

import password.manager.Controller.Controller;

public class View {
    private final MainFrame mainFrame;

    public View(Controller controller) {
        this.mainFrame = new MainFrame(controller);
    }
    
    public MainFrame getMainFrame() {
        return mainFrame;
    }
}
