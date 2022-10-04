import mayflower.*;
import java.util.ArrayList;

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
    private String[][][] chunkList;
    private MovableSetting setting;
    
    // Location strings for 7 wide chunks
    private String[][] chunk71;
    private String[][] chunk72;
    private String[][] chunk73;
    private String[][] chunk74;
    private String[][] chunk75;
    private String[][] chunk76;
    private String[][] chunk77;
    private String[][] chunk78;
    private String[][] chunk79;
    
    // Location strings for 3 wide chunks
    private String[][] chunk31;
    private String[][] chunk32;
    private String[][] chunk33;
    
    /**
       * Sets the screen with the number of lives, score, and background
       */
    public InfiniteWorld(int s, int l)
    {
        
        super(s,l);
        
        System.out.println("Loading lvl1");
        setBackground("img/BG/Background.png");
        tiles = new String[6][32];
        chunkList = new String[5][][];
        
        super.changeCurrentLevel("Infinite");
        
        this.setting = new MovableSetting();
        
        initializeAllChunks();
        selectChunks();
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
    
    public void initializeAllChunks()
    {
        chunk71 = buildChunk71();
        chunk72 = buildChunk72();
        chunk73 = buildChunk73();
        chunk74 = buildChunk74();
        chunk75 = buildChunk75();
        chunk76 = buildChunk76();
        chunk77 = buildChunk77();
        chunk78 = buildChunk78();
        chunk79 = buildChunk79();
        chunk31 = buildChunk31();
        chunk32 = buildChunk32();
        chunk33 = buildChunk33();
    }
    
    public void selectChunks()
    {
        // Generate Random Chunks for Chunks of 7 Length
        int chunk7Count = 9;
        int r71 = (int)(Math.random() * chunk7Count) + 1;
        int r72 = (int)(Math.random() * chunk7Count) + 1;
        int r73 = (int)(Math.random() * chunk7Count) + 1;
        while (r72 == r71) {
            r72 = (int)(Math.random() * chunk7Count) + 1;
        }
        while (r73 == r71 || r73 == r72) {
            r73 = (int)(Math.random() * chunk7Count) + 1;
        }

        // Generate Random Chunks for Chunks of 3 Length
        int chunk3Count = 2;
        int r31 = (int)(Math.random() * chunk3Count) + 1;
        int r32 = (int)(Math.random() * chunk3Count) + 1;
        while (r31 == r32) {
            r32 = (int)(Math.random() * chunk3Count) + 1;
        }
        
        int[] randChunkList = {r71, r72, r73, r31, r32};
        
        for (int i = 0; i < randChunkList.length; i++) {
            if (i < 3) {
                if (randChunkList[i] == 1) {
                    chunkList[i] = chunk71;
                } else if (randChunkList[i] == 2) {
                    chunkList[i] = chunk72;
                } else if (randChunkList[i] == 3) {
                    chunkList[i] = chunk73;
                } else if (randChunkList[i] == 4) {
                    chunkList[i] = chunk74;
                } else if (randChunkList[i] == 5) {
                    chunkList[i] = chunk75;
                } else if (randChunkList[i] == 6) {
                    chunkList[i] = chunk76;
                } else if (randChunkList[i] == 7) {
                    chunkList[i] = chunk77;
                } else if (randChunkList[i] == 8) {
                    chunkList[i] = chunk78;
                } else if (randChunkList[i] == 9) {
                    chunkList[i] = chunk79;
                }
            } else {
                if (randChunkList[i] == 1) {
                    chunkList[i] = chunk31;
                } else if (randChunkList[i] == 2) {
                    chunkList[i] = chunk32;
                } else if (randChunkList[i] == 3) {
                    chunkList[i] = chunk33;
                }
            }            
        }
    }
    
    public void buildWorld()
    {
        /**
        for (int i = 0; i < chunkList.length; i++) {
            for (int r = 0; r < chunkList[i].length - 1; r++)
            {
                for(int c = 0; c < chunkList[i][r].length; c++)
                {
                    tiles[r][c] = chunkList[i][r][c];
                }
            }
        }*/
        
        for (int r = tiles.length - 1; r >= 0; r--)
        {
            for (int c = 0; c < tiles[0].length; c++)
            {
                if (c <= 10) {
                    tiles[r][c + 4] = chunkList[0][r][c];
                }
            }
        }
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
    
    
    
    public String[][] buildChunk71() 
    {
        String[][] tiles = 
        {
            // Chunk 6.1: 
          //  0    1    2    3    4    5    6
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "C", " ", " ", " "},
            {" ", " ", " ", "T", " ", " ", " "},
            {" ", " ", "G", "G", "G", " ", " "},
            {" ", "G", "D", "D", "D", "G", " "},
            {"G", "D", "D", "D", "D", "D", "G"}
        
        };
        
        return tiles;
    }
    
    public String[][] buildChunk72() 
    {
        String[][] tiles = 
        {
            // Chunk 6.2: 
          //  0    1    2    3    4    5    6
            {" ", "H", " ", " ", " ", " ", " "},
            {" ", "G", " ", "C", " ", "G", " "},
            {" ", " ", " ", "G", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "G", " ", "G", " ", " "},
            {"G", " ", " ", " ", " ", " ", "G"}
        
        };
        
        return tiles;
    }
    
    public String[][] buildChunk73() 
    {
        String[][] tiles = 
        {
            // Chunk 6.3: 
          //  0    1    2    3    4    5    6
            {" ", " ", " ", " ", " ", " ", " "},
            {"L", "G", " ", " ", " ", "G", "L"},
            {"L", "D", "N", " ", " ", "D", "L"},
            {"L", "D", " ", "G", " ", "D", "L"},
            {"L", "D", " ", "C", "N", "D", "L"},
            {"G", "D", "G", "G", "G", "D", "G"}
        
        };
        
        return tiles;
    }
    
    public String[][] buildChunk74() 
    {
        String[][] tiles = 
        {
            // Chunk 6.4: 
          //  0    1    2    3    4    5    6
            {" ", " ", "C", " ", " ", " ", " "},
            {" ", "G", "G", "G", " ", " ", " "},
            {" ", " ", " ", "D", "G", " ", " "},
            {" ", " ", " ", " ", "D", "G", " "},
            {" ", "T", " ", "L", "L", "L", " "},
            {"G", "G", "G", "H", " ", "G", "G"}
        
        };
        
        return tiles;
    }
    
    public String[][] buildChunk75() 
    {
        String[][] tiles = 
        {
            // Chunk 6.5: 
          //  0    1    2    3    4    5    6
            {" ", " ", " ", "C", " ", " ", " "},
            {" ", " ", " ", "L", " ", " ", " "},
            {"L", "G", "N", " ", " ", "G", "L"},
            {"L", " ", "G", "G", "G", " ", "L"},
            {"T", " ", " ", "T", " ", " ", "T"},
            {"G", "G", "G", "G", "G", "G", "G"}
        
        };
        
        return tiles;
    }
    
    public String[][] buildChunk76() 
    {
        String[][] tiles = 
        {
            // Chunk 6.6: 
          //  0    1    2    3    4    5    6
            {" ", " ", " ", "H", " ", " ", " "},
            {"G", " ", " ", " ", " ", "N", "G"},
            {" ", " ", " ", "G", " ", " ", " "},
            {" ", "G", " ", " ", " ", "G", " "},
            {" ", " ", "L", " ", "L", " ", " "},
            {"G", "G", " ", "C", " ", "G", "G"}
        
        };
        
        return tiles;
    }
    
    public String[][] buildChunk77() 
    {
        String[][] tiles = 
        {
            // Chunk 6.7: 
          //  0    1    2    3    4    5    6
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", "L", "G", "L", "G", "L", " "},
            {" ", "L", " ", "L", " ", "L", " "},
            {" ", " ", " ", "L", " ", " ", " "},
            {"G", "N", " ", "C", " ", " ", "G"}
        
        };
        
        return tiles;
    }
    
    public String[][] buildChunk78() 
    {
        String[][] tiles = 
        {
            // Chunk 6.8: 
          //  0    1    2    3    4    5    6
            {" ", " ", " ", "T", " ", "C", " "},
            {"L", "G", " ", "G", " ", "G", "L"},
            {"L", "L", " ", " ", " ", "L", "L"},
            {" ", "L", " ", " ", " ", "L", " "},
            {" ", " ", " ", " ", " ", " ", " "},
            {"G", " ", " ", "G", " ", " ", "G"}
        
        };
        
        return tiles;
    }
    
    public String[][] buildChunk79() 
    {
        String[][] tiles = 
        {
            // Chunk 6.9: 
          //  0    1    2    3    4    5    6
            {" ", " ", "G", "G", "H", " ", " "},
            {" ", "G", "D", "D", "L", "G", " "},
            {" ", "D", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", "G", "L", "G", " ", "G", " "},
            {"G", "C", "L", " ", " ", " ", "G"}
        
        };
        
        return tiles;
    }
    
    public String[][] buildChunk31() 
    {
        String[][] tiles = 
        {
            // Chunk 3.1: 
          //  0    1    2 
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", "C", " "},
            {" ", "G", " "},
            {" ", "D", "T"},
            {"G", "D", "G"}
        
        };
        
        return tiles;
    }
    
    public String[][] buildChunk32() 
    {
        String[][] tiles = 
        {
            // Chunk 3.2: 
          //  0    1    2
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", "C", " "},
            {" ", "G", " "},
            {" ", "D", "T"},
            {"G", "D", "G"}
        
        };
        
        return tiles;
    }
    
    public String[][] buildChunk33() 
    {
        String[][] tiles = 
        {
            // Chunk 3.3: 
          //  0    1    2 
            {" ", " ", "C"},
            {" ", " ", "G"},
            {" ", " ", "D"},
            {" ", "G", "D"},
            {" ", "D", "D"},
            {"G", "D", "D"}
        
        };
        
        return tiles;
    }
    
    /**
     * Resets world.
     */
    public void resetWorld()
    {
        Mayflower.setWorld(new InfiniteWorld(getScore(), getLives()));
    }
}
