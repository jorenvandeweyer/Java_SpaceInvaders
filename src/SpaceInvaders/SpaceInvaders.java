package SpaceInvaders;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Joren Vandeweyer
 */
public class SpaceInvaders extends Application {

    static ScreenHandler handler;
    
    public static String screen1 = "start";
    public static String screen2 = "game";
    public static String screen3 = "end";
    public static String screen1FXML = "/FXML/StartScreen.fxml";
    public static String screen2FXML = "/FXML/GameScreen.fxml";
    public static String screen3FXML = "/FXML/EndScreen.fxml";
            
    
    @Override
    public void start(Stage stage){
        
        handler = new ScreenHandler();
        
        handler.load(SpaceInvaders.screen1,SpaceInvaders.screen1FXML);
        //handler.load(SpaceInvaders.screen2,SpaceInvaders.screen2FXML);
        //handler.load(SpaceInvaders.screen3,SpaceInvaders.screen3FXML);
        

        handler.show(SpaceInvaders.screen1);
        
        Group root = new Group();
        root.getChildren().addAll(handler);

        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
