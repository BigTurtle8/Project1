import mayflower.*;

/**
 * @Marcus A.
 * 
 * Reimplimentation of Mayflower Lab 6 gravity.
 * Extends AnimatedActor and uses physics-based
 * free-fall acceleration to simulate gravity
 * for actors.
 */
public class GravityActor extends AnimatedActor
{
    private static int GRAVITY = 1;
    private int velocity;
    
    /**
     * Constructor of GravityActor. Sets the
     * actor's initial velocity.
     */
    public GravityActor()
    {
        velocity = 0;
    }

    /**
     * Called every frame. Moves actor down
     * the current velocity then increases
     * that velocity. If it would move into
     * a blocking object, it resets and then
     * sets the velocity to 1 so that it
     * eventually settles on the ground.
     */
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
    
    /**
     * Tests whether the object is falling
     * by seeing whether moving it down a small
     * amount would cause it to intersect with
     * a blocking object.
     */
    public boolean isFalling()
    {
        boolean b;
        
        setLocation(getX(), getY() + 1);
        b = isBlocked();
        setLocation(getX(), getY() - 1);
        
        return !b;
    }
    
    /**
     * Returns a boolean of whether the 
     * actor is currently touching a block.
     */
    public boolean isBlocked()
    {
        return isTouching(Block.class);
    }
    
    /**
     * Returns the actor's current downward velocity.
     */
    public int getVelocity()
    {
        return velocity;
    }
    
    /**
     * Sets the actor's current downward velocity.
     */
    public void setVelocity(int v)
    {
        velocity = v;
    }
}
