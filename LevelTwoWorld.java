import mayflower.*;

public class LevelTwoWorld extends GameWorld
{
    public LevelTwoWorld(int s, int l)
    {
        super(s,l);
        setBackground("img/jack/Dead (1).png");
        super.changeCurrentLevel("levelTwo");    
        addObject(new Player(), 100, 100);
    }
    
    public void act()
    {
        super.act();
    }
}
