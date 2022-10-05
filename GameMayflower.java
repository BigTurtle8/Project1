import mayflower.*;

/**
 * @Andrew Wang
 * 
 * Creates the window for the world.
 */
public class GameMayflower extends Mayflower
{
    /**
      * Constructor, creates the window for game.
      */
    public GameMayflower()
    {
        super("Project 1", 800, 600);
    }
    
    /**
      * Sets the screen to the title world.
      */
    public void init()
    {
        
        Mayflower.setFullScreen(false);
        World w = new TitleWorld(0, 3);
        Mayflower.setWorld(w);
    }
    
}
