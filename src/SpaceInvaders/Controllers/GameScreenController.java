package SpaceInvaders.Controllers;

import SpaceInvaders.ScreenHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class GameScreenController implements ControllerHack {

    @FXML
    private AnchorPane GamePane;

    @FXML
    private AnchorPane RightDownPane;

    @FXML
    private AnchorPane RightUpPane;

    ScreenHandler handler;


    @FXML
    public void initialize() {
        //on press button screen2 execute function
    }    
    
    /**
     * Makes sure you can switch betweens screens!!!
     * @param handler the beloved handler
     */
    @Override
    public void setVisible(ScreenHandler handler) {
        this.handler = handler;
    }
    
    /**
     * Change to another screen
     * @param name name of the screen
     */
    public void change(String name){
        handler.show(name);
    }
    
}