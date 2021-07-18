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
    
    public String promptPassword() {
        return new MasterPasswordFrame().promptPassword();
    }
    
    public String promptNewServiceName() {
        return new NewServiceFrame().promptServiceName();
    }
    
    public void errorMessage(String message) {
        new ErrorMessage(message);
    }
    
    public void setServiceList(String[] serviceNames) {
        this.mainFrame.setServiceList(serviceNames);
    }
    
    public void showMainFrame() {
        mainFrame.setVisible(true);
    }
    
    public void hideMainFrame() {
        mainFrame.setVisible(false);
    }
}
