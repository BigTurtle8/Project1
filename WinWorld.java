import mayflower.*;

/**
 * @Andrew Wang
 * 
 * Creates the winning world 
 */

public class WinWorld extends GameWorld
{
    /**
      * Sets the screen with the number of lives, score, and winning background
      */
    public WinWorld(int s, int l)
    {
            super(s, l);
            setBackground("img/BG/WIN.png");
            super.changeCurrentLevel("WIN");
            showText("Your Score: " + super.getScore() + " Your lives: " + super.getLives(),100, 250, Color.BLACK);
            if(super.getLives() > 1) {
                showText(super.getScore() + " x " + super.getLives(),100, 300, Color.BLACK);
                showText("Final Score: " + super.getScore()*super.getLives(), 100, 350, Color.BLACK);
                showText("You won! Press enter to play again.",100, 400, Color.BLACK);
            }
    }
    /**
     * Resets world.
     */
    public void resetWorld()
    {
        Mayflower.setWorld(new WinWorld(getScore(), getLives()));
    }
}
