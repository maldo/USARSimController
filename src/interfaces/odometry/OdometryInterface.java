package interfaces.odometry;

import structures.odometry.OdometryData;

/**
 * 
 * @author Alberto Maldonado
 *
 */
public class OdometryInterface
{
	private OdometryData od;
	private boolean ready = false;
	
	public synchronized void readSensor(String sen)
	{
		String[] s = sen.split("\\} \\{");

		ready = false;
		
		od = new OdometryData();
		
		od.setName(s[1].split(" ")[1]);
		
		String[] pose = s[2].split(",");
		String[] pX = pose[0].split(" ");
		
		od.setX(Float.parseFloat(pX[1]));
		od.setY(Float.parseFloat(pose[1]));
		String[] t = pose[2].split("}");
		od.setTheta(Float.parseFloat(t[0]));
						
		ready = true;		
	}
	
	public OdometryData getData()
	{
		return this.od;
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
