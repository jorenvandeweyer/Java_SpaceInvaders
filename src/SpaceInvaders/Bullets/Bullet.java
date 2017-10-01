/*
 * Multiple FXML screens
 *  by Joren Vandeweyer
 */
package SpaceInvaders.Bullets;

import SpaceInvaders.FlyingObjects;
import SpaceInvaders.Ship.Ship;

/**
 *
 * @author joren
 */
public final class Bullet extends FlyingObjects{
    
    public Bullet(Ship ship){
        setX(ship.getX());
        setY(ship.getY());
        setVector(ship.getVector());
    }
    
    public boolean fly() {
        setX(getX() + Math.cos(Math.toRadians(getVector())) );
        setY(getY() + Math.sin(Math.toRadians(getVector())) );   
        
        return getX() < 0 || getY() < 0 || getX() > 736 || getY() > 736;
    }

}
