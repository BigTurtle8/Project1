import mayflower.*;

// moonwalk bug

public class MovableSettingActor extends Actor
{
    public MovableSettingActor()
    {
        
    }
    
    public void act()
    {
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT)) 
        {
            setLocation(getX() - 4, getY());
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT))
        {
            setLocation(getX() + 4, getY());
        }
    }
    
    public boolean isBlocked()
    {
        return false;
    }
}
