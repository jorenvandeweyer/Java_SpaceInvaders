/*
 * Multiple FXML screens
 *  by Joren Vandeweyer
 */
package SpaceInvaders.Bullets;

import SpaceInvaders.Enemies.Enemy;
import SpaceInvaders.Enemies.EnemyView;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author joren
 */
public class BulletView extends Pane{
    private final ArrayList<Bullet> bullet;
    private final EnemyView enemies;
    private Circle circle;

    public BulletView(EnemyView enemies) {
        this.bullet = new ArrayList<>();
        this.enemies = enemies;
    }
    
    public void add(Bullet bullet){
        this.bullet.add(bullet);
        update();
    }
    
    public void update(){
        getChildren().clear();
        Iterator<Bullet> iter = bullet.iterator();
        while (iter.hasNext()) {
            Bullet activeBullet = iter.next();
            if(activeBullet.fly()){
                iter.remove();
            } else {
                if(check(activeBullet)){
                    circle = new Circle((int)activeBullet.getX()-1, (int)activeBullet.getY()-1, 2);
                    circle.setFill(Color.BLACK);
                    getChildren().addAll(circle);
                } else {
                    update();
                    return;
                }
            }
        }
    }
    
    private boolean check(Bullet activeBullet){
        for (final Enemy target : enemies.getEnemies()) {
            if (Math.abs((int)target.getX() - (int)activeBullet.getX()) < 7 && Math.abs((int)target.getY() - (int)activeBullet.getY()) < 7) {
                this.enemies.removef(target);
                this.bullet.remove(activeBullet);
                return false;
            }
        }   
        return true;
    }
}
