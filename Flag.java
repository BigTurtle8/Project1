import mayflower.*;

/**
 * @Marcus A.
 * 
 * An interactable that ends the level
 * and brings the player to the next one.
 */
public class Flag extends Interactable
{
    /**
     * Constructor for class Flag
     */
    public Flag()
    {
        MayflowerImage img = new MayflowerImage("img/interactable/flag.png");
        img.scale(100, 100);
        setImage(img);
    }
    
    /**
     * Brings the player to next world when touched.
     */
    public void doEffect()
    {
        GameWorld w = (GameWorld) getWorld();
        w.changeWorld();
    }
}
