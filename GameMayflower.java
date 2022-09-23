import mayflower.*;

public class GameMayflower extends Mayflower
{
    
    public GameMayflower()
    {
        super("Project 1", 800, 600);
    }
    
    public void init()
    {
        Mayflower.setFullScreen(false);
        World w = new TitleWorld(0, 3);
        Mayflower.setWorld(w);
    }
    
    }
