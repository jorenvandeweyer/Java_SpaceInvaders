/*
 * Multiple FXML screens
 *  by Joren Vandeweyer
 */
package SpaceInvaders.Ship;

import SpaceInvaders.FlyingObjects;

/**
 *
 * @author joren
 */
public class Ship extends FlyingObjects{
    
    public Ship() {
        createShip();
    }

    private void createShip(){
        setX(368);
        setY(368);
        setVector(180);
        setVelocity(1);
        setCurveAcceleration(0);        
        setInterval(100);        
    }
    
    public void fly(){
        setVector( ( getVector() + 2* (getCurveAcceleration()/getVelocity()) ) % 360 );

        setX(getX() + Math.cos(Math.toRadians(getVector())) );
        setY(getY() + Math.sin(Math.toRadians(getVector())) );
    }

    public void accelerate(int direction) {
        if(direction > 0 && getCurveAcceleration() < 0)setCurveAcceleration(0);
        if(direction < 0 && getCurveAcceleration() > 0)setCurveAcceleration(0);
        
        if(getCurveAcceleration() == 0) setCurveAcceleration(direction);
        
        if(getCurveAcceleration() > 2.5 || getCurveAcceleration() < -2.5) return;
        
        setCurveAcceleration(getCurveAcceleration() + direction * 0.25);
    }   

    public void resetAcceleration() {
        setCurveAcceleration(0);
    }
    
    public void speed(double i){
        if( getVelocity()+i > 7 || getVelocity()+i <= 0) return;
        setVelocity( getVelocity() + i );
    }

}
