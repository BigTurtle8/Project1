import mayflower.*;

/**
 * @Andrew Wang
 * 
 * Creates the Level One World 
 */

public class LevelOneWorld extends GameWorld
{
    private String[][] tiles;
    private MovableSetting setting;
    
    public LevelOneWorld(int s, int l)
    {
        /**
         * Sets the screen with the number of lives, score, and level one background
         */
        
        super(s,l);
        setBackground("img/BG/Untitled Drawing.png");
        tiles = new String[6][24];
        
        super.changeCurrentLevel("Level One");
        
        this.setting = new MovableSetting();
        buildWorld();
        
    }
    
    public void act()
    {
        super.act();
        setting.act();
    }
    /**
     * Sets world with blocks and player
     */
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
                    if (Math.random() > 0.5) 
                    {
                        tiles[r][c] = "Ladder";
                    }
                    if (Math.random() > 0.6) 
                    {
                        tiles[r][c] = "Trap";
                    }
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
        
        // takes 2d array and puts it actually in world
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
                if (tiles[r][c].equals("Ladder"))
                {
                    Ladder l = new Ladder();
                    addObject(l, c * 100, r * 100);
                    setting.add(l);
                }
                //else if (tiles[r][c].equals("Player"))
                //{
                //    addObject(new Player(), c * 100, r * 100);
                //}
                
                if (tiles[r][c].equals("Trap"))
                {
                    Trap l = new Trap();
                    addObject(l, c * 100, r * 100);
                    setting.add(l);
                }
            }
        }
        
        
        addObject(new Player(), 350, 0);
        //addObject(new Trap(),400, 400);
    }
}
