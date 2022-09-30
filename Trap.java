import mayflower.*;

/**
 * @Andrew Wang
 *
 * Creates a trap that interacts with the player
 */
public class Trap extends Consumable
{
    /**
     * Constructor for objects of class Trap
     */
    
    public Trap()
    {
        MayflowerImage trap = new MayflowerImage("img/interactable/trap.png");
        trap.scale(100,100);
        setImage(trap);
    }

    /**
     *Decreases the players lives by one if the play touches the trap
     */
    public void effect()
    {
        //p.setLocation(350,0);
        GameWorld w = (GameWorld) (getWorld());
        w.changeLives(-1);
    }
}
