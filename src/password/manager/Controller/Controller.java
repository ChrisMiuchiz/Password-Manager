package password.manager.Controller;

import java.util.ArrayList;
import password.manager.Model.PasswordGenerator;
import password.manager.Model.Service;
import password.manager.Model.Storage;
import password.manager.View.PasswordGeneratorFrame;
import password.manager.View.View;

public class Controller {
    private final View view;
    private final ServiceListController svcControl;
    private final Storage storage;
    private final PasswordGenerator passGenerator;
    
    public Controller() {
        this.svcControl = new ServiceListController(this);
        this.view = new View(this);
        this.storage = new Storage();
        this.passGenerator = new PasswordGenerator();
        
        if (storage.fileExists()) {
            // Get the user's password before allowing them to use the vault
            
            while (true) {
                String password = view.promptPassword();
                storage.setPassword(password);
                ArrayList<Service> loadedServices = storage.load();
                
                if (loadedServices == null) {
                    view.errorMessage("Could not load vault with this password.");
                }
                else {
                    svcControl.addList(loadedServices);
                    break;
                }
            }
        }
        else {
            String password = view.promptSetPassword();
            storage.setPassword(password);
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
    
    public void showPassFrame() {
        view.showPassFrame();
    }
    
    public void passwordGenerate(PasswordGeneratorFrame passFrame) {
        passGenerator.setLength(passFrame.passLength());
        
        final String letters = "abcdefghijklmnopqrstuvwxyz";
        final String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String nums = "0123456789";
        final String specials = "~!@#$%^&*()_+-=?";
        
        String chars = letters;
        if (passFrame.useCaps()) chars += caps;
        if (passFrame.useNumbers()) chars += nums;
        if (passFrame.useSpecials()) chars += specials;
        
        passGenerator.setCharSet(chars.toCharArray());
        passFrame.setPass(passGenerator.generate());
    }
}
