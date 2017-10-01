package SpaceInvaders.Enemies;

import SpaceInvaders.Direction;
import SpaceInvaders.FlyingObjects;
import SpaceInvaders.Ship.Ship;

public class Enemy extends FlyingObjects{
    private Ship ship;
    private Direction dir;
    private int age;
    
    public Enemy(Ship ship){
        this.ship = ship;
        create();
    }
    
    public boolean fly(){
        this.age++;
        setX(getX() + Math.cos(Math.toRadians(getVector())) );
        setY(getY() + Math.sin(Math.toRadians(getVector())) );
        if(age>20) follow();

        return getX() < 0 || getY() < 0 || getX() > 736 || getY() > 736; 
    }
    
    private void follow(){
        double vectorX = ship.getX() - getX();
        double vectorY = ship.getY() - getY();
        
        double angle = Math.toDegrees(Math.atan2(vectorY, vectorX));
        double dif = angle - getVector();
        while(dif < 0) dif += 360;
        if(dif<=180){
            setVector(getVector()+1);
        }else {
            setVector(getVector()-1);
        }
    }
    
    private void create(){
        randomDirection();
        switch(dir){
            case SOUTH:
                setY(726);
                setX(randomDistance());
                setVector(180 + randomDegrees());
                break;
            case EAST:
                setY(randomDistance());
                setX(726);                
                setVector(90 + randomDegrees());
                break;
            case NORTH:
                setY(8);
                setX(randomDistance());
                setVector(0 + randomDegrees());
                break;
            case WEST:
                setY(randomDistance());
                setX(8);                
                setVector(-90 + randomDegrees());
                break;
        }
    }
    
    private void randomDirection(){
        setDir(Direction.getRandom());
    }
    
    private int randomDegrees(){
        return randomInt(180);
    }
    
    private int randomDistance(){
        return 10 + randomInt(716);
    }
           
    private int randomInt(int range){
        return (int)Math.floor(Math.random()*range);
    }
    
    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public Direction getDir() {
        return dir;
    }    
}