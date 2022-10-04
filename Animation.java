import mayflower.*;

/**
 * @Marcus A.
 *
 * Mostly the same as from Lab 3. Essentially
 * is a collection of images that can be flipped 
 * through repeatedly. Small change to
 * getNextFrame() so that currentFrame
 * resets to 0 in the same method call it
 * retunrs the 0th (or 1st) frame. Basically
 * means that there is a period of time where
 * curerntFrame equals the length of array frames.
 */
public class Animation
{
    private MayflowerImage[] frames;
    // how many milliseconds should go by before next frame
    private int framerate;
    private int currentFrame;
    
    /**
     * Constructor takes framerate and
     * String array of file names for the images.
     */
    public Animation(int framerate, String[] filenames) 
    {
        this.framerate = framerate;
        
        frames = new MayflowerImage[filenames.length];
        for (int i = 0; i < filenames.length; i++)
        {
            frames[i] = new MayflowerImage(filenames[i]);
        }
    }
    
    /**
     * Returns the framerate.
     */
    public int getFrameRate()
    {
        return framerate;
    }
    
    /**
     * Returns the MayflowerImage
     * array of images from the preivously
     * given string array.
     */
    public MayflowerImage[] getFrames()
    {
        return frames;
    }
    
    /**
     * Returns the frame the animation
     * will display.
     */
    public int getCurrentFrame()
    {
        return currentFrame;
    }
    
    /**
     * Returns the next frame to be displayed.
     */
    public MayflowerImage getNextFrame()
    {
        // this line first so that it is compatible
        // with OneTimeAnimation
        currentFrame %= frames.length;
        
        MayflowerImage currentImage = frames[currentFrame];
        currentFrame += 1;
        return currentImage;
    }
    
    /**
     * Scales all images in the animation.
     */
    public void scale(int w, int h)
    {
        for (MayflowerImage img : frames)
        {
            img.scale(w, h);
        }
    }
    
    /**
     * Sets the transparency of all
     * images in the animation.
     */
    public void setTransparency(int percent)
    {
        for (MayflowerImage img : frames)
        {
            img.setTransparency(percent);
        }
    }
    
    /**
     * Mirrors all images in the
     * animation horizontally.
     */ 
    public void mirrorHorizontally()
    {
        for (MayflowerImage img : frames)
        {
            img.mirrorHorizontally();
        }
    }
    
    /**
     * Sets the bounds of all images
     * in the animation.
     */ 
    public void setBounds(int x, int y, int w, int h)
    {
        for (MayflowerImage img : frames)
        {
            img.crop(x, y, w, h);
        }
    }
}
