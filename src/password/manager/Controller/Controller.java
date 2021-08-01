package password.manager.Controller;

import java.util.ArrayList;
import password.manager.Model.Model;
import password.manager.Model.Service;
import password.manager.Model.Storage;
import password.manager.View.View;

public class Controller {
    private final Model model;
    private final View view;
    private final ServiceListController svcControl;
    private final Storage storage;
    
    public Controller() {
        this.svcControl = new ServiceListController(this);
        this.model = new Model(this);
        this.view = new View(this);
        this.storage = new Storage();
        
        if (storage.fileExists()) {
            // Get the user's password before allowing them to use the vault
            String password = view.promptPassword();
            // TODO: verify password, use it to decrypt vault
        
            ArrayList<Service> loadedServices = storage.load();
        
            if (loadedServices != null) {
                svcControl.addList(loadedServices);
            }
        }
        else {
            System.out.println("File does not exist");
            // TODO: set initial password
        }
        
        view.showMainFrame();
    }

    public ServiceListController getSvcControl() {
        return svcControl;
    }

    public View getView() {
        return view;
    }
    
    public Storage getStorage() {
        return storage;
    }
}
