package interfaces.groundtruth;

import structures.Point;
import structures.groundtruth.GroundTruthData;

/**
 * 
 * @author Alberto Maldonado
 */
public class GroundTruthInterface
{

	private GroundTruthData gtd;
	private boolean ready = false;

	public synchronized void readSensor(String sen)
	{
		String[] s = sen.split("\\} \\{");

		gtd = new GroundTruthData();

		/* Location */
		String[] location = s[2].split(",");
		String[] locax = location[0].split(" ");
		
		Point l = new Point(locax[1], location[1], location[2]);
		
		gtd.setLocation(l);

		/* Orientation */
		String[] orientation = s[3].split(",");
		String[] orix = orientation[0].split(" ");
		String[] oriz = orientation[2].split("}");
			
		Point o = new Point(orix[1], orientation[1], oriz[0]);
		
		gtd.setOrientation(o);

		ready = true;
	}

	public GroundTruthData getData()
	{
		return this.gtd;
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
