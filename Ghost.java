import mayflower.*;

/**
 * @Andrew Wang
 *
 * Creates a spike that moves and interacts with the player
 */
public class Ghost extends Consumable
{
    /**
     * Constructor for objects of class spikes
     */
    private boolean isRight = true;
    public Ghost()
    {
        MayflowerImage ghost = new MayflowerImage("img/Interactable/ghost.png");
        ghost.scale(100,100);
        setImage(ghost);
    }

    /**
     * Moves the spikes and changes directions when it is blocked
     */
    public void act() {
        if (blocked())
        {
            // switches boolean
            isRight = isRight ^ true;
        }
        
        if (isRight)
        {
            setLocation(getX() + 1, getY());
        }
        else
        {
            setLocation(getX() - 1, getY());
        }
    }
    /**
    *Decreases the players lives by one if the player touches the spike
    */
    public void effect()
    {
            
        //p.setLocation(350,0);
        GameWorld w = (GameWorld) (getWorld());
        w.changeLives(-1);
    }
    
    
    public boolean blocked() {
        return isTouching(Block.class);
    }
}
