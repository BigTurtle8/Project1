import mayflower.*;

/**
 * @Marcus A.
 * 
 * Collection and controller of MovableSettingActors
 * Ensures that setting moves with each other
 * to give illusion of movement
 */
public class MovableSetting
{
    private MovableSettingActor[] settingActors;
    private int speed;
    
    /**
     * Initializes collection of actors, speed
     */
    public MovableSetting()
    {
        this.settingActors = new MovableSettingActor[0];
        speed = 4;
    }
    
    /**
     * Adds a MovableSettingActor to be moved
     */
    public void add(MovableSettingActor actor)
    {
        MovableSettingActor[] temp = new MovableSettingActor[settingActors.length + 1];
        
        for (int i = 0; i < settingActors.length; i++)
        {
            temp[i] = settingActors[i];
        }
        
        temp[temp.length - 1] = actor;
        settingActors = temp;
    }
    
    /**
     * Even though MovableSetting is not a subclass of Actor,
     * this is called every frame in GameWorlds
     * 
     * Calls each MovableSettingActor to move (see 
     * MovableSettingActor class). If a blocking
     * MovableSettingActor would move into the player, 
     * instead finds the closest position next to the 
     * player that isn't intersecting. Then, actors 
     * that have moved are directly moved to where 
     * they should be, and then the rest of the 
     * actors are moved the new, correct distance.
     */
    public void act()
    {
        int tempDist = speed;
        
        // loops through all MovableSettingActors
        for (int i = 0; i < settingActors.length; i++)
        {
            MovableSettingActor a = settingActors[i];
            
            int dir = a.moveWithSetting(tempDist);
            if (a.isBlocking())
            {
                // how far ALREADY MOVED setting needs to adjust
                int temp = a.findClosestLegalPosition(tempDist, dir);
                
                // sets already moved MovableSettingActors to correct position
                for (int j = i - 1; j >= 0; j--)
                {
                    settingActors[j].correctMove(temp);
                }
                
                // sets speed for future actors to be correct
                tempDist = tempDist - Math.abs(temp);
            }
        }
    }
}
