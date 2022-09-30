import mayflower.*;

/**
 * @Andrew Wang
 *
 * Creates a spike that moves and interacts with the player
 */
public class Spikes extends Consumable
{
    /**
     * Constructor for objects of class heart
     */
    
    public Spikes()
    {
        MayflowerImage spikes = new MayflowerImage("img/trap/spikes.png");
        spikes.scale(100,100);
        setImage(spikes);
    }

    /**
     * Moves the spikes and changes directions when it is blocked
     */
    public void act() {
        
    }
    /**
     *Increases the players lives by one if the player touches the heart
    */
    public void effect()
    {
            
        //p.setLocation(350,0);
        GameWorld w = (GameWorld) (getWorld());
        w.changeLives(1);
    }
    
    
    public boolean canMove() {
        return isTouching(Block.class);
    }
    public void move() {
      if(canMove() == false) {
          setLocation(getX()+1, getY());
        }
      else {
          setLocation(getX()-1, getY());      
      }
    }
}
