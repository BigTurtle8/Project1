import mayflower.*;

/**
 * @Andrew Wang
 *
 * Creates a coin that interacts with the player
 */
public class Coin extends Consumable
{
    /**
     * Constructor for objects of class heart
     */
    
    public Coin()
    {
        MayflowerImage coin = new MayflowerImage("img/interactable/coin.png");
        coin.scale(50,50);
        setImage(coin);
    }

    /**
     *Increases the players lives by one if the player touches the heart
    */
    public void effect(MovablePlayerActor a)
    {
            
        //p.setLocation(350,0);
        GameWorld w = (GameWorld) (getWorld());
        w.changeScore(10);
    }
}
