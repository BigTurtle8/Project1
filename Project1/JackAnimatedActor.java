import mayflower.*;

public class JackAnimatedActor extends AnimatedActor
{
    private Animation walk;
    
    public JackAnimatedActor() 
    {
        String[] filenames = new String[7];
        for (int i = 0; i < filenames.length; i++)
        {
            filenames[i] = "img/jack/Walk (" + (i + 1) + ").png";
        }
        walk = new Animation(50, filenames);
        walk.scale(30, 120);
        walk.setTransparency(5);
        
        setAnimation(walk);
    }
    
    public void act()
    {
        super.act();
    }
}
