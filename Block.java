import mayflower.*;

/**
 * @Marcus A.
 * 
 * Subclass of MovableSettingActor. Basic
 * blocking object that player can't move
 * through.
 */
public class Block extends MovableSettingActor
{
    /**
     * Constructor for class Block
     * Takes a String argument to define what
     * image it should use.
     */
    public Block(String num)
    {
        MayflowerImage img = new MayflowerImage("img/Tiles/" + num + ".png");
        img.scale(100, 100);
        setImage(img);
    }
    
    /**
     * Defines abstact method from
     * MovableSettingActor. Sets that players should
     * not be able to move through it.
     */
    public boolean isBlocking()
    {
        return isTouching(Player.class);
    }
}
