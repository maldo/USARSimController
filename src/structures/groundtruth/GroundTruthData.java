package structures.groundtruth;

import structures.Point;

public class GroundTruthData
{
	
	private Point location;
	private Point orientation;

	public synchronized Point getLocation()
	{
		return this.location;
	}

	public synchronized void setLocation(Point l)
	{
		this.location = l;
	}

	public synchronized Point getOrientation()
	{
		return this.orientation;
	}

	public synchronized void setOrientation(Point o)
	{
		this.orientation = o;
	}
}
