package structures;

public class Point
{

	private float x;
	private float y;
	private float z;
	
	public Point(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point(String x, String y, String z)
	{
		this.x = Float.parseFloat(x);
		this.y = Float.parseFloat(y);
		this.z = Float.parseFloat(z);
	}
	
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
	public synchronized float getZ()
	{
		return z;
	}
	public synchronized void setZ(float z)
	{
		this.z = z;
	}	
}
