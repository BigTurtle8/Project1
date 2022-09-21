import mayflower.*;

public class Player extends MovablePlayerActor
{
    //private Animation walk;
    //private Animation idle;
    
    public Player() 
    {
        /*
           * Set Walk Animation
           * Set Idle Animation
           * Set Fall Animation
           * Set Jump Animation
        */
        
       
       
        // WALK ANIMATIONS ******************************************
        String[] wFilenames = new String[10];
        String[] wLFilenames = new String[10];
        
        for (int i = 0; i < wFilenames.length; i++)
        {
            wFilenames[i] = "img/cat/Walk (" + (i + 1) + ").png";
            wLFilenames[i] = "img/cat/Walk (" + (i + 1) + ").png";
        }
        Animation walkRight = new Animation(50, wFilenames);
        Animation walkLeft = new Animation(50, wLFilenames);
        
        walkRight.scale(100, 87);
        walkLeft.scale(100, 87);
        
        walkRight.setBounds(18, 5, 54, 80);
        walkLeft.setBounds(28, 5, 54, 80);

        walkLeft.mirrorHorizontally();
        // WALK ANIMATIONS ******************************************
        
        
        
        // IDLE ANIMATIONS ******************************************
        String[] iFilenames = new String[10];
        String[] iLFilenames = new String[10];
        
        for (int i = 0; i < iFilenames.length; i++)
        {
            iFilenames[i] = "img/cat/Idle (" + (i + 1) + ").png";
            iLFilenames[i] = "img/cat/Idle (" + (i + 1) + ").png";
        }
        Animation idle = new Animation(50, iFilenames);
        Animation idleLeft = new Animation(50, iLFilenames);
        
        idle.scale(100, 87);
        idleLeft.scale(100, 87);
        
        idle.setBounds(18, 5, 54, 80);
        idleLeft.setBounds(28, 5, 54, 80);

        idleLeft.mirrorHorizontally();
        // IDLE ANIMATIONS ******************************************
        
        
        
        
        // FALL ANIMATIONS ******************************************
        String[] fRFilenames = new String[8];
        String[] fLFilenames = new String[8];
        
        for (int i = 0; i < fRFilenames.length; i++)
        {
            fRFilenames[i] = "img/cat/Fall (" + (i + 1) + ").png";
            fLFilenames[i] = "img/cat/Fall (" + (i + 1) + ").png";
        }
        Animation fallRight = new Animation(50, fRFilenames);
        Animation fallLeft = new Animation(50, fLFilenames);
        
        fallRight.scale(100, 87);
        fallLeft.scale(100, 87);
        
        fallRight.setBounds(13, 5, 54, 80);
        fallLeft.setBounds(33, 5, 54, 80);
        
        fallLeft.mirrorHorizontally();
        // FALL ANIMATIONS ******************************************
        
        
        
        // JUMP ANIMATIONS ******************************************
        String[] jRFilenames = new String[8];
        String[] jLFilenames = new String[8];
        for (int i = 0; i < jRFilenames.length; i++) {
            jRFilenames[i] = "img/cat/Jump (" + (i + 1) + ").png";
            jLFilenames[i] = "img/cat/Jump (" + (i + 1) + ").png";
        }
        Animation jumpRight = new Animation(50, jRFilenames);
        Animation jumpLeft = new Animation(50, jLFilenames);
        
        jumpRight.scale(100, 87);
        jumpLeft.scale(100, 87);
        
        jumpRight.setBounds(13, 5, 54, 80);
        jumpLeft.setBounds(33, 5, 54, 80);
        
        jumpLeft.mirrorHorizontally();
        // JUMP ANIMATIONS ******************************************
        
        
        
        // HURT ANIMATIONS ******************************************
        String[] hRFilenames = new String[10];
        String[] hLFilenames = new String[10];
        for (int i = 0; i < hRFilenames.length; i++) {
            hRFilenames[i] = "img/cat/Hurt (" + (i + 1) + ").png";
            hLFilenames[i] = "img/cat/Hurt (" + (i + 1) + ").png";
        }
        Animation hurtRight = new Animation(50, hRFilenames);
        Animation hurtLeft = new Animation(50, hLFilenames);
        
        hurtRight.scale(100, 87);
        hurtLeft.scale(100, 87);
        
        hurtRight.setBounds(13, 5, 54, 80);
        hurtLeft.setBounds(33, 5, 54, 80);
        
        hurtLeft.mirrorHorizontally();
        // HURT ANIMATIONS ******************************************
        
        
        
        // DEAD ANIMATIONS ******************************************
        String[] dRFilenames = new String[10];
        String[] dLFilenames = new String[10];
        for (int i = 0; i < dRFilenames.length; i++) {
            hRFilenames[i] = "img/cat/Dead (" + (i + 1) + ").png";
            hLFilenames[i] = "img/cat/Dead (" + (i + 1) + ").png";
        }
        Animation deadRight = new Animation(50, dRFilenames);
        Animation deadLeft = new Animation(50, dLFilenames);
        
        deadRight.scale(100, 87);
        deadLeft.scale(100, 87);
        
        deadRight.setBounds(13, 5, 54, 80);
        deadLeft.setBounds(33, 5, 54, 80);
        
        deadLeft.mirrorHorizontally();
        // DEAD ANIMATIONS ******************************************
        
        
        
        // SLIDE ANIMATIONS ******************************************
        String[] sRFilenames = new String[10];
        String[] sLFilenames = new String[10];
        for (int i = 0; i < sRFilenames.length; i++) {
            hRFilenames[i] = "img/cat/Slide (" + (i + 1) + ").png";
            hLFilenames[i] = "img/cat/Slide (" + (i + 1) + ").png";
        }
        Animation slideRight = new Animation(50, sRFilenames);
        Animation slideLeft = new Animation(50, sLFilenames);
        
        slideRight.scale(100, 87);
        slideLeft.scale(100, 87);
        
        slideRight.setBounds(13, 5, 54, 80);
        slideLeft.setBounds(33, 5, 54, 80);
        
        slideLeft.mirrorHorizontally();
        // SLIDE ANIMATIONS ******************************************
        
        
        setWalkAnimations(walkRight, walkLeft);
        setIdleAnimations(idle, idleLeft);
        setFallAnimations(fallRight, fallLeft);
        setJumpAnimations(jumpRight, jumpLeft);
        setHurtAnimations(hurtRight, hurtLeft);
        setDeadAnimations(deadRight, deadLeft);
        setSlideAnimations(slideRight, slideLeft);
    }
    
    public void act()
    {
        super.act();
    }
}
