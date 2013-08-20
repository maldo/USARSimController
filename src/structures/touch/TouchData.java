package structures.touch;

/**
 * 
 * @author Maldo
 */
public class TouchData
{

	private boolean Touch;

	public synchronized boolean isTouch()
	{
		return Touch;
	}

	public synchronized void setTouch(boolean Touch)
	{
		this.Touch = Touch;
	}
}
