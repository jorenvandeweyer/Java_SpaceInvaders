/*
 * Multiple FXML screens
 *  by Joren Vandeweyer
 */
package SpaceInvaders;

/**
 *
 * @author joren
 */
abstract public class FlyingObjects {
    private double x;
    private double y;
    private double vector;
    private double velocity;
    private double curveAcceleration;
    private double interval;

    public double getCurveAcceleration() {
        return curveAcceleration;
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getVector() {
        return vector;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setVector(double vector) {
        if(vector>=360){
            this.vector = vector - 360;
            return;
        }
        if(vector<0) {
            this.vector = vector + 360;
            return;
        }
        this.vector = vector;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getInterval() {
        return interval;
    }

    public void setInterval(double interval) {
        this.interval = interval;
    }
    
    public void setCurveAcceleration(double curveAcceleration) {
        this.curveAcceleration = curveAcceleration;
    }
}
