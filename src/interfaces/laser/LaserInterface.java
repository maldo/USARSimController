package interfaces.laser;

import interfaces.Constants;
import structures.laser.LaserData;

/**
 * 
 * @author Alberto Maldonado
 * 
 */
public class LaserInterface
{
	private LaserData ld;
	private boolean ready = false;

	// SEN {Time 2803.81} {Type
	// RangeScanner} {Name Scanner1} {Resolution
	// 0.0174} {FOV 3.1415} {Range -1.0000,-1.0000,-1.0000,-1.000

	public synchronized void readSensor(String sen)
	{

		String[] s = sen.split("\\} \\{");

		if (s.length != 4)
		{
			/*throw*/ new Exception("Malformed SEN Message");
		}
		
		ready = false;

		ld = new LaserData();

		ld.setName(s[1].split(" ")[1]);

		float res = Float.parseFloat(s[2].split(" ")[1]);

		ld.setResolution(res);

		float fov = Float.parseFloat(s[3].split(" ")[1]);

		ld.setFOV(fov);

		int ranges = (int) Math.ceil((double) (fov / res));

		if (Constants.MAX_LASER != ranges)
		{
			// TODO ERROR o Exception!!!

			new Exception("Different Laser ranges");
		}

		String[] range = s[4].split(",");

		String[] inirange = range[0].split(" ");

		range[0] = inirange[1];

		String last = range[range.length - 1];

		String aux = last.substring(0, last.length() - 1);

		range[range.length - 1] = aux;

		for (String x : range)
		{
			try
			{
				ld.setRangePoint(Float.parseFloat(x));
			}
			catch (NumberFormatException e)
			{
				// TODO: handle exception
			}
		}

		ready = true;
	}

	public LaserData getData()
	{
		return this.ld;
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
