import mayflower.*;

public class LevelThreeWorld extends GameWorld
{
    public LevelThreeWorld(int s, int l)
    {
        super(s,l);
        setBackground("img/dog/Dead (1).png");
        super.changeCurrentLevel("levelThree");
        addObject(new Player(), 100, 100);
    }
    
    public void act()
    {
        super.act();
    }
}
