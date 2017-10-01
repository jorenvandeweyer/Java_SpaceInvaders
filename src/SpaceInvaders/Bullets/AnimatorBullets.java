/*
 * Multiple FXML screens
 *  by Joren Vandeweyer
 */
package SpaceInvaders.Bullets;

import javafx.application.Platform;

/**
 *
 * @author joren
 */
public class AnimatorBullets implements Runnable{

    private final BulletView bulletView;

    public AnimatorBullets(BulletView bulletView) {
        this.bulletView = bulletView;
    }
    
    @Override
    public void run() {

        while (true) {
            
            
            
            Platform.runLater(bulletView::update);
                        
            try {
                Thread.sleep(5);
            }
            catch (InterruptedException e) {
            }
        }

    }    
}    

