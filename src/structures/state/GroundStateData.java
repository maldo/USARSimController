package structures.state;

/**
 * 
 * @author Maldo
 */
public class GroundStateData
{

	private float FrontSteer;
	private float RearSteer;
	private boolean LightToggle;
	private int LightIntensity;
	private int Battery;
	private int View;

	public synchronized int getBattery()
	{
		return Battery;
	}

	public synchronized void setBattery(int Battery)
	{
		this.Battery = Battery;
	}

	public synchronized float getFrontSteer()
	{
		return FrontSteer;
	}

	public synchronized void setFrontSteer(float FrontSteer)
	{
		this.FrontSteer = FrontSteer;
	}

	public synchronized int getLightIntensity()
	{
		return LightIntensity;
	}

	public synchronized void setLightIntensity(int LightIntensity)
	{
		this.LightIntensity = LightIntensity;
	}

	public synchronized boolean isLightToggle()
	{
		return LightToggle;
	}

	public synchronized void setLightToggle(boolean LightToggle)
	{
		this.LightToggle = LightToggle;
	}

	public synchronized float getRearSteer()
	{
		return RearSteer;
	}

	public synchronized void setRearSteer(float RearSteer)
	{
		this.RearSteer = RearSteer;
	}

	public synchronized int getView()
	{
		return View;
	}

	public synchronized void setView(int View)
	{
		this.View = View;
	}
}
