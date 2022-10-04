import mayflower.*;

// currently bugged
/**
 * @Andrew Wang
 * 
 * Creates the GameOver World
 */
public class GameOverWorld extends GameWorld
{
    /**
      * Sets the screen with the number of lives, score, and losing background
      */
    public GameOverWorld(int s, int l) 
    {
        super(s,l);
        //System.out.println("Loading game over");
        super.changeCurrentLevel("Game Over");
        setBackground("img/BG/Background.png");
        showText("GAME OVER",75, 200, 300, Color.BLACK);
        showText("Your Score: " + super.getScore() + " Your lives: " + super.getLives(),150, 450, Color.BLACK);
        showText("You lost! Press enter to try again.",150, 500, Color.BLACK);
        //super.changeHasLost(true);
    }
    
    /**
     * Resets world.
     */
    public void resetWorld()
    {
        Mayflower.setWorld(new GameOverWorld(getScore(), getLives()));
    }
}
