package password.manager.Model;

import java.util.ArrayList;
import password.manager.Controller.ServiceListController;

public class ServiceListModel {
    private ServiceListController controller;
    ArrayList<Service> services;
    public ServiceListModel(ServiceListController controller) {
        this.controller = controller;
        this.services = new ArrayList<>();
    }
    
    public boolean hasService(String serviceName) {
        for (Service svc : services) {
            if (svc.getServiceName().equals(serviceName)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean addService(Service svc) {
        if (hasService(svc.getServiceName())) {
            return false;
        }
        services.add(svc);
        return true;
    }
    
    public String[] getServiceNames() {
        int size = services.size();
        String[] result = new String[size];
        
        for (int i = 0; i < size; i++) {
            result[i] = services.get(i).getServiceName();
        }
        
        return result;
    }
}
