import mayflower.*;

public class WinWorld extends GameWorld
{
    public WinWorld(int s, int l)
    {
        super(s, l);
        setBackground("img/Object/Bush (4).png");
        super.changeCurrentLevel("levelWin");
        addObject(new Player(), 100, 100);
        super.changehasWon(true);
    }
    
    public void act()
    {
        super.act();
    }
}
