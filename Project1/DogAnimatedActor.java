import mayflower.*;

public class DogAnimatedActor extends AnimatedActor
{
    private Animation walk;
    
    public DogAnimatedActor() 
    {
        String[] filenames = new String[10];
        for (int i = 0; i < filenames.length; i++)
        {
            filenames[i] = "img/dog/Walk (" + (i + 1) + ").png";
        }
        walk = new Animation(50, filenames);
        walk.scale(120, 120);
        walk.setTransparency(80);
        
        setAnimation(walk);
    }
    
    public void act()
    {
        super.act();
    }
}
