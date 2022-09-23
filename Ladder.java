import mayflower.*;
 
public class Ladder extends Interactable
{
    public Ladder()
    {
        MayflowerImage ladder = new MayflowerImage("img/ladder/ladder.png");
        ladder.scale(100,100);
        setImage(ladder);
        
    }
    
    public void act()
    {
        
    }
}
