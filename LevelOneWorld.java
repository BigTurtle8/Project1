import mayflower.*;

public class LevelOneWorld extends World
{
    public LevelOneWorld()
    {
        setBackground("img/BG/BG.png");
        
        addObject(new Cat(), 100, 100);
    }
    
    public void act()
    {
    }
}
