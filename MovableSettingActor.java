import mayflower.*;

// moonwalk bug

public abstract class MovableSettingActor extends Actor
{
    public MovableSettingActor()
    {
        
    }
    
    public void act()
    {
        // move() is real act(), called in MovableSetting
    }
    
    // called in MovableSetting
    // returns direction
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
    
    // when a setting object is blocked
    // receive correct legal position and 
    // move that much
    public void correctMove(int dist)
    {
        setLocation(dist, getY());
    }
    
    // if isBlocking(), then correct to closest legal position
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
    
    public abstract boolean isBlocking();
}
