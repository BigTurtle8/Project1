import mayflower.*;

/*
 * Write a description of class GameWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    private String currentLevel;
    private Boolean hasWon;
    private int score;
    private int lives;
    /**
     * Constructor for objects of class GameWorld
     */
    public GameWorld(int s, int l){
        currentLevel = "title";
        score = s;
        lives = l;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public void changeCurrentLevel(String a) {
        currentLevel = a;
    }
    
    public Boolean gethasWon() {
        return hasWon;
    }

    public void changehasWon(Boolean a) {
        hasWon = a;
    }
    
    public void changeScore(int amount) {
        score = score + amount;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getLives() {
        return lives;
    }
    
    public void changeLives(int amount){
        lives = lives + amount;
    }
    
    public void updateText() {
        showText("Score: " + score + " Lives: " + lives, 10, 30, Color.BLACK);
    }

    public void act() {
        
        
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
        {
            if (getCurrentLevel().equals("title"))
            {
                Mayflower.setWorld(new LevelOneWorld(getScore(), getLives()));
            }
            else if (getCurrentLevel().equals("levelOne"))
            {
                Mayflower.setWorld(new LevelTwoWorld(getScore(), getLives()));
            }
            else if (getCurrentLevel().equals("levelTwo"))
            {
                Mayflower.setWorld(new LevelThreeWorld(getScore(), getLives()));
            }
            else if(getCurrentLevel().equals("levelThree")) {
                Mayflower.setWorld(new WinWorld(getScore(), getLives()));
            }
        }
        if(getCurrentLevel().equals("title")) {
            changeScore(5);
            changeLives(-1);
        }
        updateText();
        
    }

}
