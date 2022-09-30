import mayflower.*;

/**
 * @Andrew Wang
 * 
 * Creates the Level Three World
 */
public class LevelThreeWorld extends GameWorld
{
    public LevelThreeWorld(int s, int l)
    {
        /**
         * Sets the screen with the number of lives, score, and level three background
         */
        super(s,l);
        setBackground("img/BG/Untitled Drawing.png");
        super.changeCurrentLevel("Level Three");
        addObject(new Player(), 100, 100);
    }
    
    public void act()
    {
        super.act();
    }
    
    public void resetWorld()
    {
        Mayflower.setWorld(new LevelThreeWorld(getScore(), getLives()));
    }
}
