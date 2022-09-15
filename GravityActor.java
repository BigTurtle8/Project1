import mayflower.*;

public class GravityActor extends AnimatedActor
{
    private static int GRAVITY = 1;
    private int velocity;
    
    public GravityActor()
    {
        velocity = 0;
    }

    public void act()
    {
        setLocation(getX(), getY() + velocity);
        
        if (isBlocked())
        {
            setLocation(getX(), getY() - velocity);
            velocity = 1;
        }   
        else 
        {
            velocity += GRAVITY;
        }
    
        super.act();
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
        //return isTouching(Block.class);
        return false;
    }
    
    public int getVelocity()
    {
        return velocity;
    }
    
    public void setVelocity(int v)
    {
        velocity = v;
    }
}
