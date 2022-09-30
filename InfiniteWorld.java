import mayflower.*;

/**
 * @ Marcus A.
 * 
 * Alternate version of game where player
 * keeps going through randomized worlds
 * until they run out of life.
 */
public class InfiniteWorld extends GameWorld
{
    private String[][] tiles;
    private MovableSetting setting;
    
    public InfiniteWorld(int s, int l)
    {
        /**
         * Sets the screen with the number of lives, score, and level one background
         */
        super(s,l);
        
        System.out.println("Loading lvl1");
        setBackground("img/BG/Untitled Drawing.png");
        tiles = new String[6][32];
        
        super.changeCurrentLevel("Infinite");
        
        this.setting = new MovableSetting();
        
        buildRandomWorld();
    }
    
    public void act()
    {
        super.act();
        setting.act();
    }
    
    /**
     * Sets world with blocks and player
     * randomly. Will be moved to new class.
     */
    public void buildRandomWorld() {
        for(int r = tiles.length - 1; r >= 0; r--) 
        {
            for(int c = 0; c < tiles[0].length; c++) 
            {
                if (r == 5) 
                {
                    tiles[r][c] = "B";
                }
                else if (r == 4 && Math.random() > .7)
                {
                    tiles[r][c] = "B";
                    if (Math.random() > 0.5) 
                    {
                        tiles[r][c] = "L";
                    }
                    if (Math.random() > 0.3) 
                    {
                        tiles[r][c] = "T";
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
        tiles[tiles.length - 2][tiles[0].length - 1] = "F";
        
        addObject(new Player(), 350, 0);
        //addObject(new Trap(),400, 400);
        
        // takes 2d array and puts it actually in world
        for (int r = 0; r < tiles.length; r++)
        {
            for (int c = 0; c < tiles[0].length; c++)
            {
                if (tiles[r][c].equals("B"))
                {
                    Block b;
                    if (r != 0 && tiles[r - 1][c].equals("B"))
                        b = new Block("5");
                      
                    else 
                        b = new Block("2");
                        
                    addObject(b, c * 100, r * 100);
                    setting.add(b);
                }
                else if (tiles[r][c].equals("L"))
                {
                    // ladder
                    Ladder l = new Ladder();
                    addObject(l, c * 100, r * 100);
                    setting.add(l);
                }
                else if (tiles[r][c].equals("P"))
                {
                    // player
                    addObject(new Player(), c * 100, r * 100);
                }
                else if (tiles[r][c].equals("T"))
                {
                    // trap
                    Trap l = new Trap();
                    addObject(l, c * 100, r * 100);
                    setting.add(l);
                }
                else if (tiles[r][c].equals("F"))
                {
                    // flag
                    Flag f = new Flag();
                    addObject(f, c * 100, r * 100);
                    setting.add(f);
                }
                else if (tiles[r][c].equals("C"))
                {
                    // coin
                    Coin co = new Coin();
                    addObject(co, c * 100, r * 100);
                    setting.add(co);
                }
                else if (tiles[r][c].equals("H"))
                {
                    // heart
                    Heart h = new Heart();
                    addObject(h, c * 100, r * 100);
                    setting.add(h);
                }
            }
        }
    }
    
    public void resetWorld()
    {
        Mayflower.setWorld(new InfiniteWorld(getScore(), getLives()));
    }
}
