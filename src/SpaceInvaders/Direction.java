/*
 * Multiple FXML screens
 *  by Joren Vandeweyer
 */
package SpaceInvaders;

/**
 *
 * @author Joren
 */
public enum Direction {
    SOUTH, EAST, NORTH, WEST;
    
    public static Direction getRandom(){
        return values()[(int) (Math.random() * values().length)];
    }
}
