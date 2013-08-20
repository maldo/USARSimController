package interfaces.sonar;

import interfaces.Constants;
import structures.sonar.SonarData;
import structures.sonar.SonarPoint;

/**
 * 
 * @author Alberto Maldonado
 * 
 */
public class SonarInterface
{
	private SonarData sd;
	private boolean ready = false;

	// SEN {Time 98.4189} {Type 
	// Sonar} 
	// {Name F1 Range -1.0000} {Name F2 Range -1.0000}
	// {Name F3 Range -1.0000} {Name F4 Range -1.0000}
	// {Name F5 Range -1.0000} {Name F6 Range -1.0000}
	// {Name F7 Range -1.0000} {Name F8 Range -1.0000} 
	// {Name R1 Range -1.0000} {Name R2 Range 25.0000}
	// {Name R3 Range -1.0000} {Name R4 Range -1.0000}
	// {Name R5 Range -1.0000} {Name R6 Range -1.0000}
	// {Name R7 Range -1.0000} {Name R8 Range -1.0000}

	public synchronized void readSensor(String sen)
	{
		String[] s = sen.split("\\} \\{");

		ready = false;

		sd = new SonarData();

		/*
		 * MAX_SONAR_SIDE s[1...8] Front Sonar s[9...16] Rear Sonar
		 */
		
		if (s.length != 16)
		{
			/*throw*/ new Exception("Malformed SEN Message");
		}

		SonarPoint sp;
		int i;

		for (i = 1; i < Constants.MAX_SONAR_SIDE + 1; i++)
		{
			String[] aux = s[i].split(" ");
			
			try
			{
				sp = new SonarPoint(aux[1], Float.parseFloat(aux[3]));
			}
			catch (NumberFormatException e)
			{
				sp = new SonarPoint(aux[1], -1.00f);
			}
			
			sd.setFront(sp);
		}

		String last = s[(Constants.MAX_SONAR_SIDE * 2)];

		last = last.substring(0, last.length() - 1);

		s[(Constants.MAX_SONAR_SIDE * 2)] = last;

		for (; i < (Constants.MAX_SONAR_SIDE * 2) + 1; i++)
		{
			String[] aux = s[i].split(" ");
			
			try
			{
				sp = new SonarPoint(aux[1], Float.parseFloat(aux[3]));
			}
			catch (NumberFormatException e)
			{
				sp = new SonarPoint(aux[1], -1.00f);
			}
			
			sd.setRear(sp);
		}

		ready = true;
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

	public SonarData getData()
	{
		return this.sd;
	}

}
