import mayflower.*;

public class Block extends MovableSettingActor
{
    // needs to block player
    public Block()
    {
        MayflowerImage img = new MayflowerImage("img/Tiles/2.png");
        img.scale(100, 100);
        setImage("img/Tiles/2.png");
    }
    
    public void act() 
    {
        if (Mayflower.isKeyDown(Keyboard.KEY_LEFT)) 
        {
            setLocation(getX() + 4, getY());
            if (isBlocked()) 
            {
               int dist = 4;
               while (isBlocked()) 
               {
                    dist -= 1;
                    setLocation(getX() + (dist + 1), getY());
                    setLocation(getX() - dist, getY());
               }
            }
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT))
        {
            setLocation(getX() - 4, getY());
            if (isBlocked()) 
            {
               int dist = 4;
               while (isBlocked()) 
               {
                    dist -= 1;
                    setLocation(getX() - (dist + 1), getY());
                    setLocation(getX() + dist, getY());
               }
            }
        }
        
    }
    
    public boolean isBlocked()
    {
        return isTouching(Player.class);
    }
}
