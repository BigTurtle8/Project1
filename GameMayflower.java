import mayflower.*;

/**
 * @Andrew Wang
 * 
 * Creates the World 
 */
public class GameMayflower extends Mayflower
{
    
    public GameMayflower()
    {
        super("Project 1", 800, 600);
    }
    
    public void init()
    {
        /**
         * Sets the screen to the title world
        */
        Mayflower.setFullScreen(false);
        World w = new TitleWorld(0, 3);
        Mayflower.setWorld(w);
    }
    
    }
