package structures.sonar;

/**
 * 
 * @author Maldo
 */
public class SonarPoint
{

	private String Name;
	private float Range;

	public SonarPoint(String name, float range)
	{
		this.Name = name;
		this.Range = range;
	}
	
	public String getName()
	{
		return Name;
	}

	public void setName(String Name)
	{
		this.Name = Name;
	}

	public float getRange()
	{
		return Range;
	}

	public void setRange(float Range)
	{
		this.Range = Range;
	}
}
