import mayflower.*;

/**
 * @Esteban M.
 * 
 * 
 * Subclass to abstract MoveableSettingActor
 * Superclass to all interactable items
 * Makes sure interactables can be passed through and do not block player
*/
public abstract class Interactable extends MovableSettingActor
{
    /**
     * Empty act method for Interactable class as not needed
    */
    public void act() 
    {
        
    }
    
    /**
     * Inherited abstract method from MoveableSettingActor
     * Returns a false value for if the item can block the player from moving
     * Interactables let the player pass through them
     */
    public boolean isBlocking() 
    {
        return false;
    }
    
    /**
     * Abstract method to be overriden in subclasses;
     * defines effect to be triggerred when colliding
     * with MovablePlayerActor
     */
    public abstract void doEffect(MovablePlayerActor a);
}
