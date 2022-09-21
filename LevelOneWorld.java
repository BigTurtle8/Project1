import mayflower.*;

public class LevelOneWorld extends GameWorld
{
    private String[][] tiles;
    private MovableSetting setting;
    
    public LevelOneWorld()
    {
        setBackground("img/cat/Dead (1).png");
        tiles = new String[6][24];
        
        this.setting = new MovableSetting();
        buildWorld();
    }
    
    public void act()
    {
        setting.act();
    }
    
    public void buildWorld() {
        for(int r = 0; r < tiles.length; r++) 
        {
            for(int c = 0; c < tiles[0].length; c++) 
            {
                if (r == 5) 
                {
                    tiles[r][c] = "Block";
                }
                else if (r == 4 && Math.random() > .8)
                {
                    tiles[r][c] = "Block";
                }
                else 
                {
                    tiles [r][c] = "";
                }
            }
        }
        
        //tiles[0][0] = "Player";
        
        for (int r = 0; r < tiles.length; r++)
        {
            for (int c = 0; c < tiles[0].length; c++)
            {
                if (tiles[r][c].equals("Block"))
                {
                    Block b = new Block();
                    addObject(b, c * 100, r * 100);
                    setting.add(b);
                }
                //else if (tiles[r][c].equals("Player"))
                //{
                //    addObject(new Player(), c * 100, r * 100);
                //}
            }
        }
        
        addObject(new Player(), 350, 0);
    }
}
