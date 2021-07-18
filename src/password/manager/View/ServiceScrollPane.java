package password.manager.View;

import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ServiceScrollPane extends JScrollPane {
    private JList<String> list;
    public ServiceScrollPane() {
        super();
        list = new JList<>();
        this.setViewportView(list);
    }
    
    public void setServiceList(String[] serviceNames) {
        list = new JList<>(serviceNames);
        this.setViewportView(list);
    }
    
    public String[] getSelectedServices() {
        ArrayList<String> result = new ArrayList<>();
        
        for (String s : list.getSelectedValuesList()) {
            result.add(s);
        }
        
        String[] array = new String[result.size()];
        result.toArray(array);

        return array;
    }
}
