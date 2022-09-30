import mayflower.*;

/**
 * @Andrew Wang
 *
 * Creates a heart that interacts with the player
 */
public class Heart extends Consumable
{
    /**
     * Constructor for objects of class heart
     */
    
    public Heart()
    {
        MayflowerImage heart = new MayflowerImage("img/interactable/heart.png");
        heart.scale(50,50);
        setImage(heart);
    }

    /**
     *Increases the players lives by one if the player touches the heart
    */
    public void effect(MovablePlayerActor a)
    {
                    
        //p.setLocation(350,0);
        GameWorld w = (GameWorld) (getWorld());
        w.changeLives(1);
    }
}
