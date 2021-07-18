package password.manager.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import password.manager.Controller.ServiceListController;

public class ServiceListPanel extends JPanel {
    private final JButton addButton;
    private final JButton removeButton;
    private final ServiceListController controller;
    private final ServiceScrollPane pane;
    public ServiceListPanel(ServiceListController controller) {
        this.controller = controller;
        pane = new ServiceScrollPane();
        pane.setPreferredSize(new Dimension(240, 530));
        add(pane, BorderLayout.NORTH);
        
        addButton = new JButton("+");
        removeButton = new JButton("-");
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });
        
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove();
            }
        });
        
        add(addButton);
        add(removeButton);
    }
    
    public void setServiceList(String[] serviceNames) {
        pane.setServiceList(serviceNames);
    }
    
    private void add() {
        controller.addNew();
    }
    
    private void remove() {
        System.out.println("Bye");
    }
}
