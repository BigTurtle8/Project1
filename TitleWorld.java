import mayflower.*;

/**
 * @Andrew Wang
 * 
 * Creates the title World
 */
public class TitleWorld extends GameWorld
{
    public TitleWorld(int s , int l)
    {
        /**
         * Sets the screen with the number of lives, score, introductory text, and title screen*/
        
        super(s,l);
        setBackground("img/BG/Untitled Drawing.png");
        showText("Welcome to the game", 75, 40, 300, Color.BLACK);
        showText("Enter - Normal Game", 150, 400, Color.BLACK);
        showText("Space - Infinite Run", 150, 500, Color.BLACK);
        changeCurrentLevel("Title Screen");
        
        //addObject(new Player(), 100, 100);
    }
    
    public void resetWorld()
    {
        Mayflower.setWorld(new TitleWorld(getScore(), getLives()));
    }
}
