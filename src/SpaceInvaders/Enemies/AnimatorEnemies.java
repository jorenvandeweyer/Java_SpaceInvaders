/*
 * Multiple FXML screens
 *  by Joren Vandeweyer
 */
package SpaceInvaders.Enemies;

import javafx.application.Platform;

/**
 *
 * @author Joren
 */
public class AnimatorEnemies implements Runnable {
    private final EnemyView enemiesView;
    
    public AnimatorEnemies(EnemyView enemiesView){
        this.enemiesView = enemiesView;
    }
    
    @Override
    public void run() {
        
        while (true){
            
            Platform.runLater(enemiesView::update);
            
            try {
                Thread.sleep(15);
            }
            catch (InterruptedException e) {
            }            
        }
    }
}
