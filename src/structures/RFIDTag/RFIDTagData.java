package structures.RFIDTag;

import structures.Point;

public class RFIDTagData
{
	private String Name;
	private int ID;
	private Point Location;
	
	public synchronized String getName()
	{
		return Name;
	}
	public synchronized void setName(String name)
	{
		Name = name;
	}
	public synchronized int getID()
	{
		return ID;
	}
	public synchronized void setID(int iD)
	{
		ID = iD;
	}
	public synchronized Point getLocation()
	{
		return Location;
	}
	public synchronized void setLocation(Point location)
	{
		Location = location;
	}
}
