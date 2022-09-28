import mayflower.*;

/**
 * @Andrew Wang
 * 
 * Changes screens and levels
 */
public class GameWorld extends World
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
        showText(getCurrentLevel() + " Score: " + score + " Lives: " + lives, 10, 30, Color.BLACK);
    }

    public void act() {
        
        
        
        /**
         * Changes the world to the game over world if the player lost
         */  
        if(getHasLost() == true) {
                    Mayflower.setWorld(new GameOverWorld(getScore(), getLives()));
        }
        
        /**
         * Changes the hasWon to false if they loose all their lives
         */ 
        if(lives <= 0) {
            changeHasLost(true);
        }
        /**
         * Changes the level if the enter key is pressed
         */      
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
        {
            if (getCurrentLevel().equals("Title Screen"))
            {
                Mayflower.setWorld(new LevelOneWorld(getScore(), getLives()));
            }
            else if (getCurrentLevel().equals("Level One"))
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
        if(getCurrentLevel().equals("Level Two")) {
            changeScore(5);
            //changeLives(-1);
        }
        updateText();
        
    }

}
