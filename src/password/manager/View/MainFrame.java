package password.manager.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import password.manager.Controller.Controller;

public class MainFrame extends JFrame {
    private final Controller controller;
    private ServiceListPanel serviceList;
    private ServiceInfoPanel serviceInfo;
    
    public MainFrame(Controller controller) {
        this.controller = controller;
        this.initialize();
    }
    
    private void initialize() {
        serviceList = new ServiceListPanel(controller.getSvcControl());
        serviceList.setPreferredSize(new Dimension(250, 600));
        this.add(serviceList, BorderLayout.WEST);
        
        serviceInfo = new ServiceInfoPanel();
        serviceInfo.setPreferredSize(new Dimension(600, 600));
        this.add(serviceInfo, BorderLayout.EAST);
        
        this.setTitle("Password Manager");
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    
    public void setServiceList(String[] serviceNames) {
        serviceList.setServiceList(serviceNames);
    }
    
    public String[] getSelectedServices() {
        return serviceList.getSelectedServices();
    }
    
    public void setInfo(String name, String user, String pass, String notes) {
        serviceInfo.setInfo(name, user, pass, notes);
    }
}
