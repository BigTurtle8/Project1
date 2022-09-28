import mayflower.*;

/**
 * @Andrew Wang
 * 
 * Creates the Level Two World 
 */

public class LevelTwoWorld extends GameWorld
{
    public LevelTwoWorld(int s, int l)
    {
        /**
         * Sets the screen with the number of lives, score, and level two background
         */
        super(s,l);
        setBackground("img/BG/BG.png");
        super.changeCurrentLevel("Level Two");    
        addObject(new Player(), 100, 100);
    }
    
    public void act()
    {
        super.act();
    }
}
