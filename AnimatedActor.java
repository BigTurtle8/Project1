import mayflower.*;

public class AnimatedActor extends Actor
{
    private Animation animation;
    private Timer animationTimer;
    
    public AnimatedActor(){ }
    
    public void setAnimation(Animation a)
    {
        animation = a;
        animationTimer = new Timer(1000);
    }
    
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
