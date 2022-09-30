import mayflower.*;

// currently bugged
/**
 * @Andrew Wang
 * 
 * Creates the GameOver World
 */
public class GameOverWorld extends GameWorld
{
    public GameOverWorld(int s, int l) 
    {
        super(s,l);
        super.changeCurrentLevel("Game Over");
        setBackground("img/BG/Untitled Drawing.png");
        showText("GAME OVER",75, 200, 300, Color.BLACK);
        showText("Your Score: " + super.getScore() + " Your lives: " + super.getLives(),150, 450, Color.BLACK);
        showText("You lost! Press enter to try again.",150, 500, Color.BLACK);
        //super.changeHasLost(true);
    }
    
    public void resetWorld()
    {
        Mayflower.setWorld(new GameOverWorld(getScore(), getLives()));
    }
}
