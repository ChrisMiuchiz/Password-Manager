package password.manager.Controller;

import java.util.ArrayList;
import password.manager.Model.Service;
import password.manager.Model.ServiceListModel;

public class ServiceListController {
    private final Controller controller;
    private final ServiceListModel serviceList;
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
    
    public void addList(ArrayList<Service> services) {
        for (Service s : services) {
            serviceList.addService(s);
        }
        updateList();
    }
    
    public void removeCurrent() {
        String[] serviceNames = controller.getView().getSelectedServices();
        
        if (serviceNames.length > 0) {
            String message;
            
            if (serviceNames.length == 1) {
                message = String.format("Are you sure you want to delete %s?", serviceNames[0]);
            }
            else {
                message = String.format("Are you sure you want to delete these %d services?", serviceNames.length);
            }
            
            boolean delete = controller.getView().promptYesNo("Delete?", message);
            
            if (delete) {
                for (String serviceName : serviceNames) {
                    serviceList.removeService(serviceName);
                }
                updateList();
            }
        }
    }
    
    public void viewServiceInfo() {
        String[] serviceNames = controller.getView().getSelectedServices();
        
        // Nothing to show
        if (serviceNames.length < 1) {
            return;
        }
        
        // Use the first selected name by default
        String serviceName = serviceNames[0];
        
        Service service = serviceList.getServiceByName(serviceName);
        
        if (service == null) {
            return;
        }
        
        controller.getView().setInfo(service.getServiceName(), 
                service.getUserName(), service.getPassword(), 
                service.getNotes());
    }
    
    public void updateList() {
        String[] serviceNames = serviceList.getServiceNames();
        controller.getView().setServiceList(serviceNames);
    }
    
    public void saveInfo() {
        String serviceName = controller.getView().getInfoServiceName();
        
        if (serviceName.length() < 1) {
            return;
        }
        
        Service activeService = serviceList.getServiceByName(serviceName);
        
        if (activeService == null) {
            return;
        }
        
        String userName = controller.getView().getInfoUserName();
        String password = controller.getView().getInfoPassword();
        String notes = controller.getView().getInfoNotes();
        
        activeService.setUserName(userName);
        activeService.setPassword(password);
        activeService.setNotes(notes);
        
        controller.getStorage().store(serviceList.getServices());
    }
}
