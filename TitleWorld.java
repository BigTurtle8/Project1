import mayflower.*;

public class TitleWorld extends GameWorld
{
    public TitleWorld()
    {
        setBackground("img/BG/BG.png");
        
        addObject(new Player(), 100, 100);
    }
    

}
