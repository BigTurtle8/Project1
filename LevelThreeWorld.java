import mayflower.*;

public class LevelThreeWorld extends GameWorld
{
    public LevelThreeWorld()
    {
        setBackground("img/dog/Dead (1).png");
        super.changeCurrentLevel("levelThree");
        addObject(new Player(), 100, 100);
    }
    
    public void act()
    {
        super.act();
    }
}