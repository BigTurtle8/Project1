import mayflower.*;

public class NinjaAnimatedActor extends AnimatedActor
{
    private Animation run;
    
    public NinjaAnimatedActor() 
    {
        String[] filenames = new String[10];
        for (int i = 0; i < filenames.length; i++)
        {
            filenames[i] = "img/ninjagirl/Run__00" + (i) + ".png";
        }
        run = new Animation(50, filenames);
        run.scale(200, 90);
        run.setTransparency(23);
        
        setAnimation(run);
    }
    
    public void act()
    {
        super.act();
    }
}
