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
        MayflowerImage ladder = new MayflowerImage("img/interactable/ladder.png");
        ladder.scale(100,100);
        setImage(ladder);
    }
    
    /**
     * Since the effect is hard coded into MovablePlayerActor
     * does not need another effect.
     */
    public void doEffect(MovablePlayerActor a)
    {
        
    }
}
