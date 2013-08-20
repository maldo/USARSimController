package structures.laser;

import java.util.ArrayList;
import interfaces.Constants;

/**
 * 
 * @author Maldo
 */
public class LaserData
{

	private String Name;
	private float Resolution;
	private float FOV;
	private ArrayList<Float> Range = new ArrayList<Float>(Constants.MAX_LASER);

	public synchronized float getFOV()
	{
		return FOV;
	}

	public synchronized void setFOV(float FOV)
	{
		this.FOV = FOV;
	}

	public synchronized String getName()
	{
		return Name;
	}

	public synchronized void setName(String Name)
	{
		this.Name = Name;
	}

	public synchronized float getResolution()
	{
		return Resolution;
	}

	public synchronized void setResolution(float Resolution)
	{
		this.Resolution = Resolution;
	}

	public synchronized void setRangePoint(float range)
	{
		Range.add(range);
	}

	public synchronized float getRangePoint(int index)
	{
		return Range.get(index);
	}
	
	public synchronized ArrayList<Float> getRange()
	{
		return this.Range;
	}

}
