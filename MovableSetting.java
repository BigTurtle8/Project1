import mayflower.*;

// WIP

// a collection of MovableSettingActors
// so they move and don't move at the same time
public class MovableSetting
{
    private MovableSettingActor[] settingActors;
    
    public MovableSetting()
    {
        this.settingActors = new MovableSettingActor[0];
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
    
    public void act()
    {
        for (MovableSettingActor a : settingActors)
        {
            if (a.isBlocked())
            {
                return;
            }
        }
        
        for (MovableSettingActor a : settingActors)
        {
            
        }
    }
}
