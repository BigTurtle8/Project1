import mayflower.*;

/**
 * @Andrew Wang
 * 
 * Creates the title World
 */
public class TitleWorld extends GameWorld
{
    /**
     * Sets the screen with the number of lives, score, introductory text, and title screen
     */
    public TitleWorld(int s , int l)
    {
        super(s,l);
        setBackground("img/BG/Background.png");
        showText("Welcome to The Game", 70, 40, 300, Color.BLACK);
        showText("(N)ormal Game", 150, 400, Color.BLACK);
        showText("(I)nfinite Run", 150, 500, Color.BLACK);
        changeCurrentLevel("Title Screen");
    }
    
    /**
     * Resets world.
     */
    public void resetWorld()
    {
        Mayflower.setWorld(new TitleWorld(getScore(), getLives()));
    }
}
