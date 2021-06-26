package password.manager.Controller;

import password.manager.Model.Model;
import password.manager.View.View;

public class Controller {
    private final Model model;
    private final View view;
    
    public Controller() {
        this.model = new Model(this);
        this.view = new View(this);
        
        // Get the user's password before allowing them to use the vault
        String password = view.promptPassword();
        
        // TODO: verify password, use it to decrypt vault
        
        view.showMainFrame();
    }
}
