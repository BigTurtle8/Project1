import mayflower.*;

public class TitleWorld extends GameWorld
{
    public TitleWorld(int s , int l)
    {
        super(s,l);
        setBackground("img/BG/BG.png");
        showText("Welcome to the game, press enter to begin",100, 300, Color.BLACK);
        
        //addObject(new Player(), 100, 100);
    }
    

}
