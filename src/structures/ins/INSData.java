package structures.ins;

import structures.Point;

/**
 * Inertial Navigation System
 * 
 * @author Maldo
 */
public class INSData
{
	// Location
	private Point location;
	
	// Orientation
	private Point orientation;

	public synchronized Point getLocation()
	{
		return location;
	}

	public synchronized void setLocation(Point location)
	{
		this.location = location;
	}

	public synchronized Point getOrientation()
	{
		return orientation;
	}

	public synchronized void setOrientation(Point orientation)
	{
		this.orientation = orientation;
	}
}
