package structures.HMD;


// Human Motion Detection
public class HMDData
{
	private String Name;
	private float Prob;
	
	public synchronized String getName()
	{
		return Name;
	}
	public synchronized void setName(String name)
	{
		Name = name;
	}
	public synchronized float getProb()
	{
		return Prob;
	}
	public synchronized void setProb(float prob)
	{
		Prob = prob;
	}
	
}
