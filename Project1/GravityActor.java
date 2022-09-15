import mayflower.*;

public class GravityActor extends Actor
{
    public GravityActor()
    {
        
    }

    public void act()
    {
        setLocation(getX(), getY() + 1);
        
        if (isBlocked())
            setLocation(getX(), getY() - 1);
    }
    
    public boolean isFalling()
    {
        boolean b;
        
        setLocation(getX(), getY() + 1);
        b = isBlocked();
        setLocation(getX(), getY() - 1);
        
        return !b;
    }
    
    public boolean isBlocked()
    {
        return isTouching(Block.class);
    }
}
