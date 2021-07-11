package password.manager.View;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class ServiceScrollPane extends JScrollPane {
    private JList list;
    public ServiceScrollPane() {
        super();
        list = new JList<>();
        this.setViewportView(list);
    }
}
