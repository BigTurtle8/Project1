import mayflower.*;

/**
 * @Andrew Wang
 * 
 * Creates the winning world 
 */

public class WinWorld extends GameWorld
{
    public WinWorld(int s, int l)
    {
        /**
         * Sets the screen with the number of lives, score, and winning background
         */
        super(s, l);
        setBackground("img/BG/Untitled Drawing (1).png");
        super.changeCurrentLevel("WIN");
        showText("Your Score: " + super.getScore() + " Your lives: " + super.getLives(),100, 250, Color.BLACK);
        showText("You won! Press enter to play again.",100, 300, Color.BLACK);
        super.changeHasLost(false);
    }
    
    public void resetWorld()
    {
        Mayflower.setWorld(new WinWorld(getScore(), getLives()));
    }
}
