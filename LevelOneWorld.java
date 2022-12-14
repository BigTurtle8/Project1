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
    
    /**
      * Sets the screen with the number of lives, score, background
      */
    public LevelOneWorld(int s, int l)
    {
        
        super(s,l);
        
        System.out.println("Loading lvl1");
        setBackground("img/BG/Background.png");
        tiles = new String[6][32];
        
        super.changeCurrentLevel("Level One");
        
        this.setting = new MovableSetting();
        
        buildWorld();
    }
    
    /**
     * Makes setting move and runs
     * world-switching method in superclass.
     */
    public void act()
    {
        super.act();
        setting.act();
    }
    
    /**
     * Builds the world.
     */
    public void buildWorld() {
           //0  , 1  , 2  , 3  , 4  , 5  , 6  , 7  , 8  , 9  , 10 , 11 , 12 , 13 , 14 , 15 , 16 , 17 , 18 , 19 , 20 , 21 , 22 , 23 , 24 , 25 , 26 , 27 , 28 , 29 , 30 , 31 
        String[][] tempTiles = 
        {
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "C", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", "C", " ", " ", " ", " ", "G", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "C", " ", " ", " ", " ", "C", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", "G", " ", " ", " ", " ", "D", "G", " ", " ", "H", "G", " ", " ", "G", "G", "G", "G", "T", "G", " ", " ", "G", " "},
            {" ", " ", " ", " ", " ", " ", " ", "G", " ", "D", " ", " ", " ", "G", "D", "D", " ", " ", "G", " ", " ", " ", " ", " ", " ", " ", "G", " ", " ", " ", " ", " "},
            {" ", " ", " ", "P", " ", "G", "T", "D", "T", "D", "T", " ", " ", "D", "D", "D", "G", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "C", "T", "F"},
            {" ", " ", " ", "G", "G", "D", "G", "D", "G", "D", "G", "G", "G", "D", "D", "D", "D", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"}
        };
        
        tiles = tempTiles;
        boolean[] coinBoolArr = getCoinBoolArr();
        int coinCount = 0;
        
        // takes 2d array and puts it actually in world
        for (int r = 0; r < tiles.length; r++)
        {
            for (int c = 0; c < tiles[0].length; c++)
            {
                if (tiles[r][c].equals("G"))
                {
                    // grass
                    Block b = new Block("2");
                    addObject(b, c * 100, r * 100);
                    setting.add(b);
                }
                else if (tiles[r][c].equals("D"))
                {
                    // dirt
                    Block b = new Block("5");
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
                    // coin, check with bool arr
                    // to "randomize" placement
                    
                    if (coinBoolArr[coinCount])
                    {
                        Coin co = new Coin();
                        addObject(co, c * 100 + 25, r * 100 + 25);
                        setting.add(co);
                    }
                    
                    coinCount++;
                }
                else if (tiles[r][c].equals("H"))
                {
                    // heart
                    Heart h = new Heart();
                    addObject(h, c * 100 + 20, r * 100 + 20);
                    setting.add(h);
                }
            }
        }
    }
    
    /**
     * Resets world.
     */
    public void resetWorld()
    {
        Mayflower.setWorld(new LevelOneWorld(getScore(), getLives()));
    }
}
