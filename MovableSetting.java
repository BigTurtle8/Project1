import mayflower.*;

// still WIP

// a collection of MovableSettingActors
// so they move and don't move at the same time
public class MovableSetting
{
    private MovableSettingActor[] settingActors;
    private int speed = 4;
    
    public MovableSetting()
    {
        this.settingActors = new MovableSettingActor[0];
        speed = 4;
    }
    
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
    
    // KEY_LEFT = 37
    // KEY_RIGHT = 39
    public void act()
    {
        int tempDist = speed;
        
        for (int i = 0; i < settingActors.length; i++)
        {
            MovableSettingActor a = settingActors[i];
            
            int dir = a.moveWithSetting(tempDist);
            if (a.isBlocking())
            {
                // how far ALREADY MOVED setting needs to adjust
                int temp = a.findClosestLegalPosition(tempDist, dir);
                
                // sets already moved settingactors to correct position
                for (int j = i - 1; j >= 0; j--)
                {
                    settingActors[j].correctMove(temp);
                }
                
                tempDist = tempDist - Math.abs(temp);
            }
        }
    }
}
