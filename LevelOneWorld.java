import mayflower.*;

public class LevelOneWorld extends GameWorld
{
    private String[][] tiles;
    private MovableSetting setting;
    
    public LevelOneWorld(int s, int l)
    {
        super(s,l);
        setBackground("img/cat/Dead (1).png");
        tiles = new String[6][24];
        
        super.changeCurrentLevel("levelOne");
        
        this.setting = new MovableSetting();
        buildWorld();
        
    }
    
    public void act()
    {
        super.act();
        setting.act();
    }
    
    public void buildWorld() {
        for(int r = tiles.length - 1; r >= 0; r--) 
        {
            for(int c = 0; c < tiles[0].length; c++) 
            {
                if (r == 5) 
                {
                    tiles[r][c] = "Block";
                }
                else if (r == 4 && Math.random() > .7)
                {
                    tiles[r][c] = "Block";
                }
                else if (r == 3 && tiles[r + 1][c].equals("Block") && 
                    Math.random() > .7)
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
                    Block b;
                    if (r != 0 && tiles[r - 1][c].equals("Block"))
                        b = new Block("5");
                      
                    else 
                        b = new Block("2");
                        
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
