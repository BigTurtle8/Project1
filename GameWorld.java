import mayflower.*;

/**
 * @Andrew Wang
 * 
 * Changes screens and levels
 */
public abstract class GameWorld extends World
{
    private String currentLevel;
    private boolean hasLost;
    private int score;
    private int lives;
    /**
     * Constructor for objects of class GameWorld
     * Sets the current level to title screen and sets the starting score and lives
     */ 
    public GameWorld(int s, int l){
        currentLevel = "Title Screen";
        score = s;
        lives = l;
    }

    /** 
     * Returns the current level
     */
    public String getCurrentLevel() {
        return currentLevel;
    }

    public GameWorld getGameWorld() {
        return this;
    }
    /**
     * Changes the current level
     */
    public void changeCurrentLevel(String a) {
        currentLevel = a;
    }
    /**
     * Returns true if the player has won the game
     */
    public boolean getHasLost() {
        return hasLost;
    }
    /**
     * Changes the status of the game to won or lost
     */
    public void changeHasLost(boolean a) {
        hasLost = a;
    }
    /**
     * Changes the score by a desired amount
     */
    public void changeScore(int amount) {
        score = score + amount;
    }
    /**
     * Gets the current Score
     */
    public int getScore() {
        return score;
    }
    /**
     * Gets the current number of lives
     */
    public int getLives() {
        return lives;
    }
    /**
     * Changes the number of lives by a desired amount
     */
    public void changeLives(int amount){
        lives = lives + amount;
    }
    /**
     * Updates the text on the screen to accurately display the score and number of lives
     */
    public void updateText() {
        showText(" Score: " + score + " Lives: " + lives, 10, 30, Color.BLACK);
    }
    
    /**
     * Update the text on the screen to show the current level
     */
    public void updateLevelText() {
        showText(getCurrentLevel(),590, 30, Color.BLACK);
    }
    
    /**
     * Controls changing worlds
     */
    public void act() {
        if ((getCurrentLevel().equals("Title Screen")
              || getCurrentLevel().equals("Game Over")
              || getCurrentLevel().equals("WIN")) &&
            Mayflower.isKeyDown(Keyboard.KEY_ENTER))
        {
            System.out.println("aa");
            changeHasLost(false);
            Mayflower.setWorld(new LevelOneWorld(0, 3));
        }
        
        if ((getCurrentLevel().equals("Game Over")
              || getCurrentLevel().equals("WIN")) &&
            Mayflower.isKeyDown(Keyboard.KEY_ENTER))
        {
            System.out.println("aa");
            changeHasLost(false);
            Mayflower.setWorld(new TitleWorld(0, 3));
        }
        
        if (getCurrentLevel().equals("Game Over")) {
            Mayflower.setWorld(new GameOverWorld(getScore(), getLives()));
        } 
        
        /**
         * Changes the hasLost to true if they lose all their lives
         */ 
        if(lives <= 0) {
            changeHasLost(true);
        }
        
        // temp
        if(getCurrentLevel().equals("Level One")) {
            changeScore(5);
            //changeLives(-1);
        }
        updateText();
        updateLevelText();
        
        /**
         * Changes the world to the game over world if the player lost
         */  
        if(getHasLost() == true) {
              Mayflower.setWorld(new GameOverWorld(getScore(), getLives()));
        }
    }
    
    public void changeWorld()
    {
        if (getCurrentLevel().equals("Level One"))
        {
            Mayflower.setWorld(new LevelTwoWorld(getScore(), getLives()));
        }
        else if (getCurrentLevel().equals("Level Two"))
        {
            Mayflower.setWorld(new LevelThreeWorld(getScore(), getLives()));
        }
        else if(getCurrentLevel().equals("Level Three")) {
            if(getHasLost() == false) {
                Mayflower.setWorld(new WinWorld(getScore(), getLives()));
            }
        }
    }
    
    public abstract void resetWorld();
}
