import mayflower.*;

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
    
    public void act()
    {
        super.act();
        
        String newAction = null;
        if (currentAction == null) {
            newAction = "idle";
        }
        
        //int x = getX();
        //int y = getY();
        int w = getWidth();
        int h = getHeight();
        
        int dist;
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) &&
            !(w + getX() > 800)) {
            //setLocation(getX() + 4, getY());
            newAction = "walkRight";
            direction = "right";
            
            //if (isBlocked()) 
            //{
            //    dist = 4;
            //    while (isBlocked()) 
            //    {
            //        dist -= 1;
            //        setLocation(getX() - (dist + 1), getY());
            //        setLocation(getX() + dist, getY());
            //    }
            //}
        }
            
        else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) &&
            !(getX() < 0)) {
            //setLocation(getX() - 4, getY());
            newAction = "walkLeft";
            direction = "left";
            
            //if (isBlocked()) 
            //{
            //    dist = 4;
            //    while (isBlocked()) 
            //    {
            //        dist -= 1;
            //        setLocation(getX() + (dist + 1), getY());
            //        setLocation(getX() - dist, getY());
            //    }
            //}
        }
        
        //else if (Mayflower.isKeyDown(Keyboard.KEY_UP) &&
        //    !(getY() < 0)) {
        //    setLocation(getX(), getY() - 1);
        //    
        //    if (isBlocked())
        //        setLocation(getX(), getY() + 1);
        //}
        //
        //else if (Mayflower.isKeyDown(Keyboard.KEY_DOWN) &&
        //    !(h + getY() > 600)) {
        //    setLocation(getX(), getY() + 1);
        //    
        //    if (isBlocked())
        //        setLocation(getX(), getY() + 1);
        //}
            
        else 
        {
            newAction = "idle";
            if (direction != null && direction.equals("left"))
                newAction = "idleLeft";
            
        }
        
        if (isTouching(Ladder.class) && Mayflower.isKeyDown(Keyboard.KEY_UP)) 
        {
            setCanJump(false);
            setVelocity(0);
            setLocation(getX(), getY() - 4);
        }
        
        if (canJump && Mayflower.isKeyDown(Keyboard.KEY_UP) && !isFalling()) {
            setVelocity(-18);
        } else if (canJump && Mayflower.isKeyPressed(Keyboard.KEY_UP) && doubleJumpAvail) {
            setVelocity(-18);
            doubleJumpAvail = false;
        }
        
        if (isFalling())
        {
            newAction = "fallRight";
            if (direction != null && direction.equals("left"))
                newAction = "fallLeft";
        } else {
            doubleJumpAvail = true;
        }
            
        
        
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
    }
    
    public void setAnimation(Animation a)
    {
        super.setAnimation(a);
    }
    
    public void setWalkAnimations(Animation right, Animation left)
    {
        walkRight = right;
        walkLeft = left;
    }
    
    public void setIdleAnimations(Animation right, Animation left) 
    {
        idle = right;
        idleLeft = left;
    }
    
    public void setFallAnimations(Animation right, Animation left)
    {
        fallRight = right;
        fallLeft = left;
    }
    
    public void setJumpAnimations(Animation right, Animation left) 
    {    
        jumpRight = right;
        jumpLeft = left;
    }
    
    public void setHurtAnimations(Animation right, Animation left) 
    {    
        hurtRight = right;
        hurtLeft = left;
    }
    
    public void setDeadAnimations(Animation right, Animation left) 
    {    
        deadRight = right;
        deadLeft = left;
    }
    
    public void setSlideAnimations(Animation right, Animation left) 
    {    
        slideRight = right;
        slideLeft = left;
    }
    
    public void setCanJump(boolean bool) 
    {
        canJump = bool;
    }
}
