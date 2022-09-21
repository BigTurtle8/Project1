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
    /**
     * Constructor for objects of class GameWorld
     */
    public GameWorld(){
        currentLevel = "title";
    }
    public void act() {
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER) && getCurrentLevel().equals("title")) {
            Mayflower.setWorld(new LevelOneWorld());
            changeCurrentLevel("LevelOne");
        }
    }
    public String getCurrentLevel() {
        return currentLevel;
    }
    public void changeCurrentLevel(String a) {
        currentLevel = a;
    }
}
