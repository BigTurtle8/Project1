import mayflower.*;

public class GameMayflower extends Mayflower
{
    
    public GameMayflower()
    {
        super("Lab 6", 800, 600);
    }
    
    public void init()
    {
        Mayflower.setFullScreen(false);
        World w = new TitleWorld();
        Mayflower.setWorld(w);
    }
}