package structures.sonar;

import java.util.ArrayList;
import interfaces.Constants;

/**
 * 
 * @author Maldo
 */
public class SonarData
{

	private ArrayList<SonarPoint> FrontSonar = new ArrayList<SonarPoint>(
			Constants.MAX_SONAR_SIDE);
	private ArrayList<SonarPoint> RearSonar = new ArrayList<SonarPoint>(
			Constants.MAX_SONAR_SIDE);

	public synchronized void setFront(SonarPoint sp)
	{
		FrontSonar.add(sp);
	}

	public synchronized SonarPoint getFront(int index)
	{
		return FrontSonar.get(index);
	}

	public synchronized void setRear(SonarPoint sp)
	{
		RearSonar.add(sp);
	}

	public synchronized SonarPoint getRear(int index)
	{
		return RearSonar.get(index);
	}
}
