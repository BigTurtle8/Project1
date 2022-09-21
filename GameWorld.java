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
    /**
     * Constructor for objects of class GameWorld
     */
    public GameWorld(){
        currentLevel = "title";
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

    public void act() {
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
        {
            if (getCurrentLevel().equals("title"))
            {
                Mayflower.setWorld(new LevelOneWorld());
            }
            else if (getCurrentLevel().equals("levelOne"))
            {
                Mayflower.setWorld(new LevelTwoWorld());
            }
            else if (getCurrentLevel().equals("levelTwo"))
            {
                Mayflower.setWorld(new LevelThreeWorld());
            }
            else if(getCurrentLevel().equals("levelThree")) {
                Mayflower.setWorld(new WinWorld());
            }
        }        
    }

}
