package SpaceInvaders;

import SpaceInvaders.Controllers.ControllerHack;
import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Joren Vandeweyer
 * 
 * SOURCES:
 * (0) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/StackPane.html
 * (1) https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html
 * (2) https://docs.oracle.com/javase/tutorial/java/IandI/super.html
 */

public class ScreenHandler extends StackPane{
    
    private final HashMap<String, Node> screens = new HashMap<>();
 
    public ScreenHandler(){
        super();
    }
    
    /**
     * Load a screen 
     * @param name screen name
     * @param fxml screen fxml file
     */
    public void load(String name, String fxml){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            
            ControllerHack hack = (ControllerHack) loader.getController();
            hack.setVisible(this);
            
            screens.put(name, root);
        } catch (IOException ex) {
            System.out.println("loading '" + name + "' failed... :(\r\n");
        }
    }
    
    /**
     * Unload a screen
     * @param name screen name
     */
    public void remove(String name){
        boolean status = (screens.remove(name)==null);
        if(status) System.out.println("Screen '" + name + "' not found... :(\r\n");
    }
    
    /**
     * Set a screen to active
     * @param name screen name 
     */
    public void show(String name){
        if(screens.get(name)==null){
            System.out.println("Screen '" + name + "' isn't loaded... :(\r\n");
            return;
        }
        getChildren().clear();
        getChildren().add(screens.get(name));            
    }
  
}
