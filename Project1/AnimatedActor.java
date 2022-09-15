import mayflower.*;

public class AnimatedActor extends GravityActor
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
        super.act();
        
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
