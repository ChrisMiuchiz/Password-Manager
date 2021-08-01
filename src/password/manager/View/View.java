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
    
    public String promptSetPassword() {
        return new SetMasterPasswordFrame().promptPassword();
    }
    
    public String promptNewServiceName() {
        return new NewServiceFrame().promptServiceName();
    }
    
    public void errorMessage(String message) {
        new ErrorMessage(message);
    }
    
    public boolean promptYesNo(String title, String message) {
        return new YesNoDialog().prompt(title, message);
    }
    
    public void setServiceList(String[] serviceNames) {
        this.mainFrame.setServiceList(serviceNames);
    }
    
    public String[] getSelectedServices() {
        return this.mainFrame.getSelectedServices();
    }
    
    public void setInfo(String name, String user, String pass, String notes) {
        mainFrame.setInfo(name, user, pass, notes);
    }
    
    public String getInfoServiceName() {
        return mainFrame.getInfoServiceName();
    }
    
    public String getInfoUserName() {
        return mainFrame.getInfoUserName();
    }
    
    public String getInfoPassword() {
        return mainFrame.getInfoPassword();
    }
    
    public String getInfoNotes() {
        return mainFrame.getInfoNotes();
    }
    
    public void showMainFrame() {
        mainFrame.setVisible(true);
    }
    
    public void hideMainFrame() {
        mainFrame.setVisible(false);
    }
}
