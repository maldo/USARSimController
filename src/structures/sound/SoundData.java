package structures.sound;

public class SoundData
{

	private String Name;
	
	private float Loudness;
	
	private float Duration;

	public synchronized String getName()
	{
		return Name;
	}

	public synchronized void setName(String name)
	{
		Name = name;
	}

	public synchronized float getLoudness()
	{
		return Loudness;
	}

	public synchronized void setLoudness(float loudness)
	{
		Loudness = loudness;
	}

	public synchronized float getDuration()
	{
		return Duration;
	}

	public synchronized void setDuration(float duration)
	{
		Duration = duration;
	}
	
	
}
