package structures.victim;

import java.util.ArrayList;

public class VictimData
{
	/**
	 * Victim Sensor
	 * 
	 * SEN {Type VictSensor} {Name string } {PartName string } {Location x , y ,
	 * z } {PartName string } {Location x , y , z }
	 * 
	 * Where:
	 * 
	 * {Name string }" string ' is the sensor name.
	 * 
	 * {PartName string }
	 * " string ' is the name of the victim part that was discovered by the sensor. It can be one of 7 values: :: "
	 * Head",
	 * 
	 * "Arm", "Hand", "Chest", "Pelvis", "Leg", and "Foot".
	 * 
	 * Please note that the sensor does not differentiate between real victim's
	 * part and false alarms. It is up to the controller to perform this task.
	 * 
	 * {Location x , y , z } Relavite location, based on the sensor's position
	 * and rotation, of the victim part where x , y , and z are in meters.
	 * 
	 * • Example:
	 * 
	 * SEN {Type VictSensor} {Name VictimSensor} {PartName Leg} {Location
	 * 2.05,0.33,0.46} {PartName Leg} {Location 2.51,0.44,0.39}
	 */
	
	private String Name;
	private boolean Status;
	private ArrayList<BodyPart> ListBp = new ArrayList<BodyPart>();
	
	public synchronized String getName()
	{
		return Name;
	}
	public synchronized void setName(String name)
	{
		Name = name;
	}
	public synchronized boolean isStatus()
	{
		return Status;
	}
	public synchronized void setStatus(boolean status)
	{
		Status = status;
	}
	public synchronized ArrayList<BodyPart> getBodyParts()
	{
		return ListBp;
	}
	
	public synchronized BodyPart getBodyPart(int index)
	{
		return ListBp.get(index);
	}
	
	public synchronized void setBodyParts(ArrayList<BodyPart> list)
	{
		this.ListBp = list;
	}
	
	public synchronized void setBodyPart(BodyPart bp)
	{
		ListBp.add(bp);
	}
	
	
	
}
