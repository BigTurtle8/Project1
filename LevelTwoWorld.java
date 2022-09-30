import mayflower.*;

/**
 * @Andrew Wang
 * 
 * Creates the Level Two World 
 */

public class LevelTwoWorld extends GameWorld
{
    private String[][] tiles;
    private MovableSetting setting;
    
    public LevelTwoWorld(int s, int l)
    {
        /**
         * Sets the screen with the number of lives, score, and level two background
         */
        super(s,l);
        setBackground("img/BG/Untitled Drawing.png");
        super.changeCurrentLevel("Level Two");    
        
        tiles = new String[6][32];
        setting = new MovableSetting();
        buildWorld();
    }
    
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
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "D", " ", " ", " ", "C", " ", " ", " ", " ", " ", " ", "C", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "G", " ", "D", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "G", " ", " ", " ", " ", "C", " "},
            {" ", " ", " ", " ", "L", "G", " ", " ", " ", " ", " ", "G", " ", " ", "D", "L", "G", " ", " ", "L", "G", "G", "G", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "L", "D", " ", " ", " ", "L", "G", " ", " ", " ", "H", " ", " ", " ", " ", "L", "D", " ", " ", " ", " ", " ", " ", "G", " ", " ", " ", " "},
            {" ", " ", " ", "P", "L", "D", " ", " ", " ", "T", " ", "C", " ", " ", "G", "T", " ", " ", "C", "L", "D", "H", " ", " ", "G", " ", " ", " ", "T", "T", "T", "F"},
            {" ", " ", " ", "G", "G", "D", " ", " ", " ", " ", " ", "G", "L", " ", "D", "G", " ", " ", "G", "G", "D", "G", " ", " ", " ", " ", " ", " ", "G", "G", "G", "G"}
        };
        
        tiles = tempTiles;
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
        Mayflower.setWorld(new LevelTwoWorld(getScore(), getLives()));
    }
}
