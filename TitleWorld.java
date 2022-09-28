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
        setBackground("img/BG/BG.png");
        showText("Welcome to the game, press enter to begin",100, 300, Color.BLACK);
        
        //addObject(new Player(), 100, 100);
    }
    

}
