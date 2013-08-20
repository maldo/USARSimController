package interfaces.ins;

import structures.Point;
import structures.ins.INSData;

/**
 * 
 * @author Alberto Maldonado
 *
 */
public class InsInterface
{
	private INSData ins;
	private boolean ready = false;
	
	public synchronized void readSensor(String sen)
	{
		String[] s = sen.split("\\} \\{");

		ready = false;
		
		ins = new INSData();
		
		String[] location = s[2].split(",");
		String[] locX = location[0].split(" ");
		
		Point l = new Point(locX[1], location[1], location[2]);
		ins.setLocation(l);
		
		String[] orientation = s[3].split(",");
		String[] orix = orientation[0].split(" ");
		String[] oriz = orientation[2].split("}");
			
		Point o = new Point(orix[1], orientation[1], oriz[0]);
		ins.setOrientation(o);
				
		ready = true;		
	}
	
	public INSData getData()
	{
		return this.ins;
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
