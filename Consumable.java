import mayflower.*;

/**
 * @Esteban M.
 * 
 * Abstract class that extends interactable.
 * Automatically destroys iteself after 
 * doEffect() is called.
 */
public abstract class Consumable extends Interactable
{
    /**
     * Does effect and then removes self.
     */
    public void doEffect(MovablePlayerActor a)
    {
        effect(a);
        
        World w = getWorld();
        w.removeObject(this);
    }
    
    /**
     * Where subclasses define what is done before removing self.
     */
    public abstract void effect(MovablePlayerActor a);
}
