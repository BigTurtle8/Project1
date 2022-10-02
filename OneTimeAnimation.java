import mayflower.*;

/**
 * @Marcus A.
 * 
 * A subclass of animation that only
 * runs the animation a single time.
 */
public class OneTimeAnimation extends Animation
{
	/**
	 * Constructor simply calls Animation
	 * constructor with same arguments.
	 */
	public OneTimeAnimation(int framerate, String[] filenames)
	{
		super(framerate, filenames);
	}
	
	/**
	 * Overriding method from Animation
	 * to NOT loop through animations.
	 */
	public MayflowerImage getNextFrame()
	{
		// checks whether current frame is out of bounds
		// meaning the animation is finished
		if (getCurrentFrame() == getFrames().length)
			return null;
			
		// otherwise, continue through anim normally
		return super.getNextFrame();
	}
}
