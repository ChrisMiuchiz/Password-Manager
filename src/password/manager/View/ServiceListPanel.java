package password.manager.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ServiceListPanel extends JPanel {
    JButton addButton;
    JButton removeButton;
    public ServiceListPanel() {
        JScrollPane pane  = new ServiceScrollPane();
        pane.setPreferredSize(new Dimension(240, 530));
        add(pane, BorderLayout.NORTH);
        
        addButton = new JButton("+");
        removeButton = new JButton("-");
        
        add(addButton);
        add(removeButton);
    }
}
