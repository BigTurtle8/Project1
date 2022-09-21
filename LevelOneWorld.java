import mayflower.*;

public class LevelOneWorld extends GameWorld
{
    public LevelOneWorld()
    {
        setBackground("img/cat/Dead (1).png");
        super.changeCurrentLevel("levelOne");
        addObject(new Player(), 100, 100);
    }
    
    public void act()
    {
        super.act();
    }
}
