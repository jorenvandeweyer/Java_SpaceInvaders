/*
 * Multiple FXML screens
 *  by Joren Vandeweyer
 */
package SpaceInvaders.Ship;

import javafx.application.Platform;

/**
 *
 * @author joren
 */
public class AnimatorShip implements Runnable{

    private final Ship ship;
    private final ShipView shipView;

    public AnimatorShip(Ship ship, ShipView shipView) {
        this.ship = ship;
        this.shipView = shipView;
    }
    
    @Override
    public void run() {

        while (true) {
            
            ship.fly();
            Platform.runLater(shipView::update);
                        
            try {
                Thread.sleep((int)(40/ship.getVelocity()));
            }
            catch (InterruptedException e) {
            }
        }

    }    
}    

