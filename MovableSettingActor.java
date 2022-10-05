import mayflower.*;

/**
 * @Marcus A.
 * 
 * Abstract class from which setting actors extend from.
 * Stored in a MovableSetting class.
 */
public abstract class MovableSettingActor extends Actor
{
    /**
     * Although extends Actor, act() is not used
     * and does nothing because each MovableSettingActor 
     * needs to act with the rest of the setting, 
     * not by itself.
     */
    public void act()
    {
        // move() is real act(), called in MovableSetting
    }
    
    /**
     * This method is called within MovableSetting.
     * Moves object depending on user input and
     * by a given int speed. Returns the direction
     * moved (KEY_RIGHT or KEY_LEFT).
     */
    public int moveWithSetting(int speed)
    {
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT)) 
        {
            setLocation(getX() - speed, getY());
            return Keyboard.KEY_RIGHT;
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT))
        {
            setLocation(getX() + speed, getY());
            return Keyboard.KEY_LEFT;
        }
        
        return -1;
    }
    
    /**
     * This method is called within MovableSetting
     * whenever a blocking actor moves into the player.
     * After finding the distance that needs to be
     * corrcted, this method is called for actors
     * that had already moved, essentially correcting
     * it too.
     */
    public void correctMove(int dist)
    {
        setLocation(getX() + dist, getY());
    }
    
    /**
     * This method is called within MovableSetting
     * if this isBlocking(), then finds and moves
     * this actor to a legal position after taking
     * the needed contextual integers. It then returns
     * the distance that was moved so that MovableSetting
     * can change already moved actors and so it can
     * calculate the correct distance for the rest of
     * the actors to move.
     */
    public int findClosestLegalPosition(int currentSpeed, int dir)
    {
        // final dist moved in opposite direction
        int distMoved = 0;
            
        if (dir == Keyboard.KEY_LEFT)
        {
            while (isBlocking()) 
            {
                distMoved--;
                setLocation(getX() - 1, getY());
            }
        } else if (dir == Keyboard.KEY_RIGHT)
        {
            while (isBlocking()) 
            {
                distMoved++;
                setLocation(getX() + 1, getY());
            }
        }
        
        return distMoved;
    }
    
    /**
     * Abstract method that is defined in subclasses.
     * Defines whether that class should block the
     * player from moving through them.
     */
    public abstract boolean isBlocking();
}
