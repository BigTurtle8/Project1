import mayflower.*;

/**
 * @Esteban M.
 * 
 * 
 * Subclass to Actor class
 * Creates timer to control player animations
 * When timer elapses, animations flip frames
 */
public class AnimatedActor extends Actor
{
    private Animation animation;
    private Timer animationTimer;
    
    /**
     * Set animation method
     * Creates a timer of value 1000
     * Timer is used to control player animations
     */
    public void setAnimation(Animation a)
    {
        animation = a;
        animationTimer = new Timer(1000);
    }
    
    /**
     * Returns animation.
     */
    public Animation getAnimation()
    {
        return animation;
    }
    
    /**
     * Checks if animation is not null
     * When the timer finishes:
         * Resets Timer
         * Changes player animation frame to the next frame
     */
    public void act()
    {   
        if (animation != null)
        {
            if (animationTimer.isDone())
            {
                animationTimer.reset();
                setImage(animation.getNextFrame());
            }
        }
    }
}
