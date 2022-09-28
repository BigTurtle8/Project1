import mayflower.*;

/**
 * @Esteban M.
 * 
 * 
 * Creates frame animations for each avaliable animation player can perform
 * Sets animations in MoveablePlayerActor
 */
public class Player extends MovablePlayerActor
{
    
    /**
     * Constructor for Player
     * Creates and sets frames for each type of Player Animation
     * ANIMATIONS:
          * Walk Animation
          * Idle Animation
          * Fall Animation
          * Jump Animation
          * Hurt Animation
          * Dead Animation
          * Slide Animation
     */
    public Player() 
    {
        /**
           * ANIMATION CONSTRUCTION:
                * Create 2 string arrays for filenames of each frame in the animation
                * For loop to input animation filenames in each list
                * Create left and right animation with filename array
                * Scale both left and right animations to appropriate size
                * Mirror left animation horizontally to flace left
                * Set appropriate bounds for animation
        */
        
        
       
        /**  WALK ANIMATIONS  *******************************************/ 
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
        
        walkLeft.mirrorHorizontally();
        
        walkRight.setBounds(18, 5, 54, 80);
        walkLeft.setBounds(28, 5, 54, 80);
        
        
        
        /**  IDLE ANIMATIONS  *******************************************/
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
        
        idleLeft.mirrorHorizontally();
        
        idle.setBounds(18, 5, 54, 80);
        idleLeft.setBounds(28, 5, 54, 80);
        
        
        
        
        /**  FALL ANIMATIONS  *******************************************/
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
        
        fallLeft.mirrorHorizontally();
        
        fallRight.setBounds(13, 5, 54, 80);
        fallLeft.setBounds(33, 5, 54, 80);
        
        
        
        /**  JUMP ANIMATIONS  *******************************************/
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
        
        jumpLeft.mirrorHorizontally();
        
        jumpRight.setBounds(13, 5, 54, 80);
        jumpLeft.setBounds(33, 5, 54, 80);
        
        
        
        /**  HURT ANIMATIONS  *******************************************/
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
        
        hurtLeft.mirrorHorizontally();
        
        hurtRight.setBounds(13, 5, 54, 80);
        hurtLeft.setBounds(33, 5, 54, 80);
        
        
        
        /**  DEAD ANIMATIONS  *******************************************/
        String[] dRFilenames = new String[10];
        String[] dLFilenames = new String[10];
        for (int i = 0; i < dRFilenames.length; i++) {
            dRFilenames[i] = "img/cat/Dead (" + (i + 1) + ").png";
            dLFilenames[i] = "img/cat/Dead (" + (i + 1) + ").png";
        }
        Animation deadRight = new Animation(50, dRFilenames);
        Animation deadLeft = new Animation(50, dLFilenames);
        
        deadRight.scale(100, 87);
        deadLeft.scale(100, 87);
        
        deadLeft.mirrorHorizontally();
        
        deadRight.setBounds(13, 5, 54, 80);
        deadLeft.setBounds(33, 5, 54, 80);
        
        
        
        /**  SLIDE ANIMATIONS  ******************************************/
        String[] sRFilenames = new String[10];
        String[] sLFilenames = new String[10];
        for (int i = 0; i < sRFilenames.length; i++) {
            sRFilenames[i] = "img/cat/Slide (" + (i + 1) + ").png";
            sLFilenames[i] = "img/cat/Slide (" + (i + 1) + ").png";
        }
        Animation slideRight = new Animation(50, sRFilenames);
        Animation slideLeft = new Animation(50, sLFilenames);
        
        slideRight.scale(100, 87);
        slideLeft.scale(100, 87);
        
        slideLeft.mirrorHorizontally();
        
        slideRight.setBounds(13, 5, 54, 80);
        slideLeft.setBounds(33, 5, 54, 80);
        
        
        
        /**  Sets every animation in MoveablePlayerActor */
        setWalkAnimations(walkRight, walkLeft);
        setIdleAnimations(idle, idleLeft);
        setFallAnimations(fallRight, fallLeft);
        setJumpAnimations(jumpRight, jumpLeft);
        setHurtAnimations(hurtRight, hurtLeft);
        setDeadAnimations(deadRight, deadLeft);
        setSlideAnimations(slideRight, slideLeft);
    }
    
    /**
     * Repeats act method from superclass
     */
    public void act()
    {
        super.act();
    }
}
