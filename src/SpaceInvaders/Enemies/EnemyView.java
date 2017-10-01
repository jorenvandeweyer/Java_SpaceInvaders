/*
 * Multiple FXML screens
 *  by Joren Vandeweyer
 */
package SpaceInvaders.Enemies;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Joren
 */
public class EnemyView extends Pane{
    private final ArrayList<Enemy> enemies;
    private Rectangle rectangle;
    
    public EnemyView(){
        this.enemies = new ArrayList<>();
    }
    
    public void add(Enemy enemy){
        this.enemies.add(enemy);
        update();
    }
    
    public void update(){       
        getChildren().clear();
        if(enemies.isEmpty()) return;
        Iterator<Enemy> iter = enemies.iterator();
        while (iter.hasNext()) {
            Enemy activeEnemy = iter.next();
            if(activeEnemy.fly()) iter.remove();
            rectangle = new Rectangle((int)activeEnemy.getX()-6, (int)activeEnemy.getY()-6, 12, 12);
            rectangle.setFill(Color.BLACK);
            getChildren().addAll(rectangle);
        }
    }

    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }

    public void removef(Enemy target) {
        this.enemies.remove(target);
    }
}
