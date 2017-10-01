package SpaceInvaders.Controllers;

import SpaceInvaders.AnimatorLevel;
import SpaceInvaders.Ship.AnimatorShip;
import SpaceInvaders.Ship.ShipView;
import SpaceInvaders.Ship.Ship;
import SpaceInvaders.Bullets.AnimatorBullets;
import SpaceInvaders.Bullets.BulletView;
import SpaceInvaders.Bullets.Bullet;
import SpaceInvaders.Enemies.EnemyView;
import SpaceInvaders.Enemies.Enemy;
import SpaceInvaders.Enemies.AnimatorEnemies;
import SpaceInvaders.ScreenHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class StartScreenController implements ControllerHack {

    ScreenHandler handler;

    @FXML
    private AnchorPane GamePane;

    @FXML
    private AnchorPane RightDownPane;

    @FXML
    private AnchorPane RightUpPane;
    
    @FXML
    private AnchorPane Pane;

    private Ship ship;
    private Enemy enemy;
    
    private AnimatorShip animatorShip;
    private AnimatorBullets animatorBullets;
    private AnimatorEnemies animatorEnemies;
    private AnimatorLevel animatorLevel;
    private Thread thread;
    private Thread threadBullets;
    private Thread threadEnemies;
    private Thread threadLevel;
    
    private ShipView shipView;
    private BulletView bulletView;
    private EnemyView enemiesView;

    @FXML
    public void initialize() {
        
        draw();
        startThread();
        Pane.setFocusTraversable(true);
        Pane.setOnKeyPressed(this::keysPress);
        Pane.setOnKeyReleased(this::keysRelease);
        
    }    
    
    public void startThread(){
        animatorShip = new AnimatorShip(ship, shipView);
        thread = new Thread(animatorShip);
        thread.setDaemon(true);
        thread.start();
        
        animatorBullets = new AnimatorBullets(bulletView);
        threadBullets = new Thread(animatorBullets);
        threadBullets.setDaemon(true);
        threadBullets.start();
        
        animatorEnemies = new AnimatorEnemies(enemiesView);
        threadEnemies = new Thread(animatorEnemies);
        threadEnemies.setDaemon(true);
        threadEnemies.start();
        
        animatorLevel = new AnimatorLevel(enemiesView,ship);
        threadLevel = new Thread(animatorLevel);
        threadLevel.setDaemon(true);
        threadLevel.start();
        
    }
    
    public void keysPress(KeyEvent e){
        switch(e.getCode()){
            case LEFT:
                ship.accelerate(-1);
                break;
                
            case RIGHT:
                ship.accelerate(1);
                break;
            
            case UP:
                ship.speed(1);
                break;
            
            case DOWN:
                ship.speed(-1);
            break;
            
            case SPACE:
                fire();
            break;
        }        
    }
    
    public void keysRelease(KeyEvent e){
        switch(e.getCode()){
            case LEFT:
                ship.resetAcceleration();
                System.out.println("Left Release");
                break;
            case RIGHT:
                System.out.println("Right Release");
                ship.resetAcceleration();
                break;
        }
    }
    
    public void fire(){
        bulletView.add(new Bullet(ship));
    }
    
    public void draw(){
        ship = new Ship();
        
        shipView = new ShipView(ship);
        enemiesView = new EnemyView();
        bulletView = new BulletView(enemiesView);
            
        GamePane.getChildren().clear();
        GamePane.getChildren().add(shipView);
        GamePane.getChildren().add(bulletView);
        GamePane.getChildren().add(enemiesView);
               
    }
       
    public void change(String name){
        handler.show(name);
    }
    
    @Override
    public void setVisible(ScreenHandler handler) {
        this.handler = handler;
    }
 }