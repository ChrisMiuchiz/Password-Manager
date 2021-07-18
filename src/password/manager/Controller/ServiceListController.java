package password.manager.Controller;

import password.manager.Model.Service;
import password.manager.Model.ServiceListModel;

public class ServiceListController {
    private Controller controller;
    private ServiceListModel serviceList;
    public ServiceListController(Controller controller) {
        this.controller = controller;
        this.serviceList = new ServiceListModel(this);
    }
    
    public void addNew() {
        while (true) {
            String newServiceName = controller.getView().promptNewServiceName();
            
            if (newServiceName == null) {
                break;
            }
            
            Service freshService = new Service();
            freshService.setServiceName(newServiceName);
            
            if (newServiceName.length() < 1) {
                controller.getView().errorMessage("Service name cannot be empty!");
            }
            else if (!serviceList.addService(freshService)) {
                controller.getView().errorMessage("Service already exists!");
            }
            else {
                updateList();
                break;
            }
        } 
    }
    
    public void updateList() {
        String[] serviceNames = serviceList.getServiceNames();
        controller.getView().setServiceList(serviceNames);
    }
}
