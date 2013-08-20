package interfaces.HMD;

import structures.HMD.HMDData;

/**
 * 
 * @author Alberto Maldonado
 *
 */
public class HMDInterface
{
	private HMDData hmd;
	
	private boolean ready = false;
	
	public synchronized void readSensor(String sen)
	{
		String[] s = sen.split("\\} \\{");
		
		ready = false;
		
		hmd = new HMDData();

		hmd.setName(s[1].split(" ")[1]);
		
		String[] p = s[2].split(" ");
		String[] x = p[2].split("}");
		hmd.setProb(Float.parseFloat(x[0]));
		
		ready = true;
	}
	
	public HMDData getData()
	{
		return this.hmd;
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
