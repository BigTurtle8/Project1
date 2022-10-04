import mayflower.*;

/**
 * @Andrew Wang
 *
 * Creates a spike that moves and interacts with the player
 */
public class Ghost extends Consumable
{
    private MayflowerImage ghostLeft, ghostRight;
    private boolean isRight;
    
    /**
     * Constructor for objects of class spikes
     */
    public Ghost()
    {
        ghostLeft = new MayflowerImage("img/interactable/ghost.png");
        ghostLeft.scale(100,100);
        
        ghostRight = new MayflowerImage("img/interactable/ghost.png");
        ghostRight.scale(100, 100);
        ghostRight.mirrorHorizontally();
        
        setImage(ghostLeft);
        
        isRight = true;
    }

    /**
     * Moves the spikes and changes directions when it is blocked
     */
    public void act() {
        if (blocked())
        {
            // switches boolean
            isRight = isRight ^ true;
            if (isRight)
                setImage(ghostRight);
                
            else
                setImage(ghostLeft);
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
     * Decreases the players lives by one if the player touches the spike
     */
    public void effect(MovablePlayerActor a)
    {
            
        //p.setLocation(350,0);
        GameWorld w = (GameWorld) (getWorld());
        w.changeLives(-1);
    }
    
    /**
     * Detects collision with block
     */
    public boolean blocked() {
        return isTouching(Block.class);
    }
}
