package interfaces.sound;

import structures.sound.SoundData;

/**
 * 
 * @author Alberto Maldonado
 *
 */
public class SoundInterface
{

	private SoundData sd;
	private boolean ready = false;
	
	
	public synchronized void readSensor(String sen)
	{
		String[] s = sen.split("\\} \\{");
		
		ready = false;
		
		sd = new SoundData();

		sd.setName(s[1].split(" ")[1]);
		
		sd.setLoudness(Float.parseFloat(s[2].split(" ")[1]));
		
		String[] d = s[3].split(" ");
		sd.setDuration(Float.parseFloat(d[1].split("}")[0]));
				
		ready = true;
	}
	
	public SoundData getData()
	{
		return this.sd;
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
