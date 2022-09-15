import mayflower.*;

public class MovablePlayerActor extends GravityActor
{
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idle;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
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
    }
    
    public void act()
    {
        super.act();
        
        String newAction = null;
        if (currentAction == null)
            newAction = "idle";
        
        //int x = getX();
        //int y = getY();
        int w = getWidth();
        int h = getHeight();
        
        int dist;
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) &&
            !(w + getX() > 800)) {
            setLocation(getX() + 4, getY());
            newAction = "walkRight";
            direction = "right";
            
            if (isBlocked()) 
            {
                dist = 4;
                while (isBlocked()) 
                {
                    dist -= 1;
                    setLocation(getX() - (dist + 1), getY());
                    setLocation(getX() + dist, getY());
                }
            }
        }
            
        else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) &&
            !(getX() < 0)) {
            setLocation(getX() - 4, getY());
            newAction = "walkLeft";
            direction = "left";
            
            if (isBlocked()) 
            {
                dist = 4;
                while (isBlocked()) 
                {
                    dist -= 1;
                    setLocation(getX() + (dist + 1), getY());
                    setLocation(getX() - dist, getY());
                }
            }
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
        
        if (Mayflower.isKeyDown(Keyboard.KEY_UP) &&
            !isFalling()) {
            setVelocity(-18);
        }
        
        if (isFalling())
        {
            newAction = "fallRight";
            if (direction != null && direction.equals("left"))
                newAction = "fallLeft";
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
    }
    
    public void setAnimation(Animation a)
    {
        super.setAnimation(a);
    }
    
    public void setWalkRightAnimation(Animation ani)
    {
        walkRight = ani;
    }
    
    public void setWalkLeftAnimation(Animation ani)
    {
        walkLeft = ani;
    }
    
    public void setIdleAnimation(Animation ani)
    {
        idle = ani;
    }
    
    public void setIdleLeftAnimation(Animation ani)
    {
        idleLeft = ani;
    }
    
    public void setFallRightAnimation(Animation ani)
    {
        fallRight = ani;
    }
    
    public void setFallLeftAnimation(Animation ani)
    {
        fallLeft = ani;
    }
}
