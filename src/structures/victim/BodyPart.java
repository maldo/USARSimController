package structures.victim;

import structures.Point;

public class BodyPart
{
	private PartEnum part;
	
	private Point location;
		
	
	public synchronized Point getLocation()
	{
		return location;
	}
	public synchronized void setLocation(Point location)
	{
		this.location= location;
	}
	public synchronized void setPart(PartEnum part)
	{
		this.part = part;
	}
	public synchronized PartEnum getPart()
	{
		return part;
	}
}
