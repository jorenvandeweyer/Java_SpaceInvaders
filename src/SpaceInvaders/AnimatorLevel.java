/*
 * Multiple FXML screens
 *  by Joren Vandeweyer
 */
package SpaceInvaders;

import SpaceInvaders.Enemies.Enemy;
import SpaceInvaders.Enemies.EnemyView;
import SpaceInvaders.Ship.Ship;
import javafx.application.Platform;

/**
 *
 * @author Joren
 */
public class AnimatorLevel implements Runnable{
    private final EnemyView enemyView;
    private final Ship ship;
    
    public AnimatorLevel(EnemyView enemyView, Ship ship){
        this.enemyView = enemyView;
        this.ship = ship;
    }
    
    @Override
    public void run(){
        
        while(true){
            
            Platform.runLater( () -> enemyView.add(new Enemy(ship)));
            
            try {
                Thread.sleep((long) (5*1000*Math.random()));
            } catch (InterruptedException e){
                
            }
        }
    }
    
}
