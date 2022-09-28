import mayflower.*;

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
        setBackground("img/BG/BG.png");
        showText("Your Score: " + super.getScore() + " Your lives: " + super.getLives(),100, 250, Color.BLACK);
        showText("You lost! Press enter to try again.",100, 300, Color.BLACK);
        super.changeHasLost(true);
    }
}
