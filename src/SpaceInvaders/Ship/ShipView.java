/*
 * Multiple FXML screens
 *  by Joren Vandeweyer
 */
package SpaceInvaders.Ship;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author joren
 */
public final class ShipView extends Region{
    private Rectangle rectangle;
    
    private final Ship ship;
    
    public ShipView(Ship ship){
        this.ship = ship;
        update();
    }
    
    public void update(){
        getChildren().clear();
        rectangle = new Rectangle((int)ship.getX()-8, (int)ship.getY()-8, 16, 16);
        rectangle.setFill(Color.RED);
        getChildren().addAll(rectangle);
              
    }
    
}
