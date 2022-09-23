import mayflower.*;

public class Block extends MovableSettingActor
{
    // needs to block player
    public Block(String num)
    {
        MayflowerImage img = new MayflowerImage("img/Tiles/" + num + ".png");
        img.scale(100, 100);
        setImage(img);
    }
    
    public boolean isBlocking()
    {
        return isTouching(Player.class);
    }
}
