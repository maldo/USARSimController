package structures.odometry;

/**
 * 
 * @author Maldo
 */
public class OdometryData
{
	// Pose

	private String Name;
	private float x; //m
	private float y; //m
	private float theta; //rad
		
	public synchronized float getX()
	{
		return x;
	}
	public synchronized void setX(float x)
	{
		this.x = x;
	}
	public synchronized float getY()
	{
		return y;
	}
	public synchronized void setY(float y)
	{
		this.y = y;
	}
	public synchronized float getTheta()
	{
		return theta;
	}
	public synchronized void setTheta(float theta)
	{
		this.theta = theta;
	}
	public synchronized String getName()
	{
		return Name;
	}
	public synchronized void setName(String name)
	{
		Name = name;
	}

	
}
