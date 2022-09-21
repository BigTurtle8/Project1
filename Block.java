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
    
    public boolean isBlocking()
    {
        return isTouching(Player.class);
    }
}
