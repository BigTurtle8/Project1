import mayflower.*;

public class Animation
{
    private MayflowerImage[] frames;
    // how many milliseconds should go by before next frame
    private int framerate;
    private int currentFrame;
    
    public Animation(int framerate, String[] filenames) 
    {
        this.framerate = framerate;
        
        frames = new MayflowerImage[filenames.length];
        for (int i = 0; i < filenames.length; i++)
        {
            frames[i] = new MayflowerImage(filenames[i]);
        }
    }
    
    public int getFrameRate()
    {
        return framerate;
    }
    
    public MayflowerImage getNextFrame()
    {
        MayflowerImage currentImage = frames[currentFrame];
        currentFrame += 1;
        currentFrame %= frames.length;
        return currentImage;
    }
    
    public void scale(int w, int h)
    {
        for (MayflowerImage img : frames)
        {
            img.scale(w, h);
        }
    }
    
    public void setTransparency(int percent)
    {
        for (MayflowerImage img : frames)
        {
            img.setTransparency(percent);
        }
    }
    
    public void mirrorHorizontally()
    {
        for (MayflowerImage img : frames)
        {
            img.mirrorHorizontally();
        }
    }
    
    public void setBounds(int x, int y, int w, int h)
    {
        for (MayflowerImage img : frames)
        {
            img.crop(x, y, w, h);
        }
    }
}
