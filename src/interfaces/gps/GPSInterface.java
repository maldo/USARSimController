package interfaces.gps;

import structures.gps.GPSSensorData;
import interfaces.Utils;

/**
 * 
 * @author Alberto Maldonado
 */
public class GPSInterface
{

	private GPSSensorData gps;
	private boolean ready = false;

	public synchronized void readSensor(String sen)
	{
		/*
		 * d =
		 * "GPS} {Name string } {Latitude int , float , char} {Longitude int , float , char} {Fix int} {Satellites int}"
		 * 
		 * If Fix is 0, there is no GPS signal so there are not Latitude and
		 * Longitude fields and Satellites = 0
		 */

		String[] s = sen.split("\\} \\{");
		
		if (s.length != 6)
		{
			/*throw*/ new Exception("Malformed SEN Message");
		}

		ready = false;

		gps = new GPSSensorData();

		String fixstr = Utils.partialString(sen, "Fix", "}", 0);

		int fix = Integer.parseInt(fixstr);

		if (fix == 0)
		{
			gps.setFix(fix);

			System.err.println("No GPS Signal");

			String sat = s[s.length - 1];

			String fieldsat = Utils.partialString(sat, "Satellites",
					"}", 0);

			int satellites = Integer.parseInt(fieldsat);
			gps.setSatellites(satellites);

			/*
			 * Longitude and Latitude are 0 due to java initialization
			 */
		}
		else
		{
			// There's signal!!
			
			if (s.length != 6)
			{
				new Exception("Malformed SEN Message");
			}
			
			gps.setFix(fix);

			String sat = s[s.length - 1];

			/* Satellite */
			String fieldsat = Utils.partialString(sat, "Satellites",
					"}", 0);
			int satellites = Integer.parseInt(fieldsat);
			gps.setSatellites(satellites);

			/* Latitude */
			String[] latitude = s[2].split(",");
			String[] latdeg = latitude[0].split(" ");

			gps.setLatitudeDeg(Integer.parseInt(latdeg[1]));
			gps.setLatitudeMin(Float.parseFloat(latitude[1]));
			gps.setLatitudePos(latitude[2].charAt(0));

			/* Longitude */
			String[] longitude = s[3].split(",");
			String[] longdeg = longitude[0].split(" ");

			gps.setLongitudeDeg(Integer.parseInt(longdeg[1]));
			gps.setLongitudeMin(Float.parseFloat(longitude[1]));
			gps.setLongitudePos(longitude[2].charAt(0));
		}

		ready = true;

	}

	public GPSSensorData getData()
	{
		return this.gps;
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
