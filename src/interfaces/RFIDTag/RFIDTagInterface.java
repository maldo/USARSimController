package interfaces.RFIDTag;

import structures.Point;
import structures.RFIDTag.RFIDTagData;

/**
 * 
 * @author Alberto Maldonado
 *
 */
public class RFIDTagInterface
{
	private RFIDTagData rfid;
	private boolean ready = false;
	
	//SEN {Type RFIDTag} {Name string} {ID int} {Location float, float, float}
	
	public synchronized void readSensor(String sen)
	{
		String[] s = sen.split("\\} \\{");
		
		ready = false;
		
		rfid = new RFIDTagData();

		rfid.setName(s[1].split(" ")[1]);
		
		rfid.setID(Integer.parseInt(s[2].split(" ")[1]));
		
		String[] location = s[3].split(",");
		String[] locx = location[0].split(" ");

		String[] locz = location[2].split("}");
		
		Point l = new Point(locx[1], location[1], locz[0]);
		rfid.setLocation(l);
		
		ready = true;
	}
	
	public RFIDTagData getData()
	{
		return this.rfid;
	}
	
	public boolean isReady()
	{
		if (ready)
		{
			ready = false;
			return true;
		}
		return false;
	}
	
}
