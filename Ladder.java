import mayflower.*;

/**
 * @Esteban M.
 * 
 * 
 * Subclass of Interactable
 * Allows players to pass through it
 * Gives the ladder an image
*/
public class Ladder extends Interactable
{
    /**
     * Ladder Constructor method
     * Creates a new MayFlowerImage with ladder png
     * Scales the MayFlowerImage
     * Sets the MayFlowerImage as the ladder image
    */
    public Ladder()
    {
        MayflowerImage ladder = new MayflowerImage("img/ladder/ladder.png");
        ladder.scale(100,100);
        setImage(ladder);
    }

    /**
     * Empty act method as it doesnt need to do anything
    */
    public void act()
    {
        
    }
    
    public void doEffect()
    {
        
    }
}
