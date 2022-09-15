import mayflower.*;

public class Cat extends MovablePlayerActor
{
    //private Animation walk;
    //private Animation idle;
    
    public Cat() 
    {
        String[] wFilenames = new String[10];
        for (int i = 0; i < wFilenames.length; i++)
        {
            wFilenames[i] = "img/cat/Walk (" + (i + 1) + ").png";
        }
        Animation walkRight = new Animation(50, wFilenames);
        walkRight.scale(100, 87);
        walkRight.setBounds(18, 5, 54, 80);
        // walk.setTransparency(50);
        
        String[] wLFilenames = new String[10];
        for (int i = 0; i < wLFilenames.length; i++)
        {
            wLFilenames[i] = "img/cat/Walk (" + (i + 1) + ").png";
        }
        Animation walkLeft = new Animation(50, wLFilenames);
        walkLeft.scale(100, 87);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(28, 5, 54, 80);
        
        String[] iFilenames = new String[10];
        for (int i = 0; i < iFilenames.length; i++)
        {
            iFilenames[i] = "img/cat/Idle (" + (i + 1) + ").png";
        }
        Animation idle = new Animation(50, iFilenames);
        idle.scale(100, 87);
        idle.setBounds(18, 5, 54, 80);
        
        String[] iLFilenames = new String[10];
        for (int i = 0; i < iLFilenames.length; i++)
        {
            iLFilenames[i] = "img/cat/Idle (" + (i + 1) + ").png";
        }
        Animation idleLeft = new Animation(50, iLFilenames);
        idleLeft.scale(100, 87);
        idleLeft.mirrorHorizontally();
        idleLeft.setBounds(28, 5, 54, 80);
        
        String[] fRFilenames = new String[8];
        for (int i = 0; i < fRFilenames.length; i++)
        {
            fRFilenames[i] = "img/cat/Fall (" + (i + 1) + ").png";
        }
        Animation fallRight = new Animation(50, fRFilenames);
        fallRight.scale(100, 87);
        fallRight.setBounds(13, 5, 54, 80);
        
        String[] fLFilenames = new String[8];
        for (int i = 0; i < fLFilenames.length; i++)
        {
            fLFilenames[i] = "img/cat/Fall (" + (i + 1) + ").png";
        }
        Animation fallLeft = new Animation(50, fLFilenames);
        fallLeft.scale(100, 87);
        fallLeft.mirrorHorizontally();
        fallLeft.setBounds(33, 5, 54, 80);
        
        setWalkRightAnimation(walkRight);
        setWalkLeftAnimation(walkLeft);
        setIdleAnimation(idle);
        setIdleLeftAnimation(idleLeft);
        setFallRightAnimation(fallRight);
        setFallLeftAnimation(fallLeft);
    }
    
    public void act()
    {
        super.act();
    }
}
