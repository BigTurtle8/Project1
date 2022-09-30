import mayflower.*;
import java.util.List;

/**
 * @Marcus A.
 * 
 * Extends GravityActor. Defines how 
 * a player controlled character
 * should move.
 */
public class MovablePlayerActor extends GravityActor
{
    private Animation idle, idleLeft;
    private Animation walkRight, walkLeft;
    private Animation fallRight, fallLeft;
    private Animation jumpRight, jumpLeft;
    private Animation hurtRight, hurtLeft;
    private Animation deadRight, deadLeft;
    private Animation slideRight, slideLeft;
    
    private boolean doubleJumpAvail;
    private boolean canJump;
    
    private String currentAction;
    private String direction;
    
    /**
     * Constructor of MovablePlayerActor.
     * Initializes vairable.
     */
    public MovablePlayerActor()
    {
        walkRight = null;
        walkLeft = null;
        idle = null;
        idleLeft = null;
        currentAction = null;
        direction = "right";
        canJump = true;
    }
    
    /**
     * Called every frame. Sets the animation of the
     * player to be correct depending on user input.
     * Also defines the vertical movement of the player,
     * including jumping, double jump, and going up ladders.
     */
    public void act()
    {
        super.act();
        
        String newAction = null;
        if (currentAction == null) {
            newAction = "idle";
        }
        
        int w = getWidth();
        int h = getHeight();
        
        // setting animations depending on input
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) &&
            !(w + getX() > 800)) {
            newAction = "walkRight";
            direction = "right";
        }
            
        else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) &&
            !(getX() < 0)) {
            newAction = "walkLeft";
            direction = "left";
        }
            
        else 
        {
            // if not moving, idle
            newAction = "idle";
            if (direction != null && direction.equals("left"))
                newAction = "idleLeft";
        }
        
        // ladder movement
        if (isTouching(Ladder.class) && Mayflower.isKeyDown(Keyboard.KEY_UP)) 
        {
            setCanJump(false);
            setVelocity(0);
            setLocation(getX(), getY() - 4);
        }
        
        // jump and double jump
        if (canJump && Mayflower.isKeyDown(Keyboard.KEY_UP) && !isFalling()) 
        {
            setVelocity(-18);
        } 
        else if (canJump && Mayflower.isKeyPressed(Keyboard.KEY_UP) && doubleJumpAvail) 
        {
            setVelocity(-18);
            doubleJumpAvail = false;
        }
        
        // setting fall animation, overrides other animations
        if (isFalling())
        {
            newAction = "fallRight";
            if (direction != null && direction.equals("left"))
                newAction = "fallLeft";
        } 
        else 
        {
            doubleJumpAvail = true;
        }
        
        // actually setting the animations
        if (newAction != null && !newAction.equals(currentAction))
        {
            if (newAction.equals("idle"))
                setAnimation(idle);
                
            else if (newAction.equals("idleLeft"))
                setAnimation(idleLeft);
                
            else if (newAction.equals("walkRight"))
                setAnimation(walkRight);
                
            else if (newAction.equals("walkLeft"))
                setAnimation(walkLeft);
                
            else if (newAction.equals("fallRight"))
                setAnimation(fallRight);
                
            else if (newAction.equals("fallLeft"))
                setAnimation(fallLeft);
                
            currentAction = newAction;
        }
        
        setCanJump(true);
        
        // trigger effects of all touching interactables
        List<Interactable> intersectingObjects = getIntersectingObjects(Interactable.class);
        for (Interactable i : intersectingObjects)
        {
            i.doEffect(this);
        }
        
        // checks if fell off screen, if so then reset world
        // with -1 life
        if (getY() > 600)
        {
            GameWorld wo = (GameWorld) (getWorld());
            wo.changeLives(-1);
            
            wo.resetWorld();
        }
    }
    
    public void takeDamage(int dam)
    {
        GameWorld w = (GameWorld) (getWorld());
        w.changeLives(-1 * dam);
    }
    
    /**
     * Sets walk animations to use.
     */
    public void setWalkAnimations(Animation right, Animation left)
    {
        walkRight = right;
        walkLeft = left;
    }
    
    /**
     * Sets idle animations to use.
     */
    public void setIdleAnimations(Animation right, Animation left) 
    {
        idle = right;
        idleLeft = left;
    }
    
    /**
     * Sets fall animations to use.
     */
    public void setFallAnimations(Animation right, Animation left)
    {
        fallRight = right;
        fallLeft = left;
    }
    
    /**
     * Sets jump animations to use.
     */
    public void setJumpAnimations(Animation right, Animation left) 
    {    
        jumpRight = right;
        jumpLeft = left;
    }
    
    /**
     * Sets hurt animations to use.
     */
    public void setHurtAnimations(Animation right, Animation left) 
    {    
        hurtRight = right;
        hurtLeft = left;
    }
    
    /**
     * Sets death animations to use.
     */
    public void setDeadAnimations(Animation right, Animation left) 
    {    
        deadRight = right;
        deadLeft = left;
    }
    
    /**
     * Sets slide animations to use.
     */
    public void setSlideAnimations(Animation right, Animation left) 
    {    
        slideRight = right;
        slideLeft = left;
    }
    
    /**
     * Sets whether the player can jump at the current time.
     */
    public void setCanJump(boolean bool) 
    {
        canJump = bool;
    }
}
