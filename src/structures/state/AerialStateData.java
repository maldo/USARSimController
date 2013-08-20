package structures.state;

public class AerialStateData
{

	private boolean LightToggle;
	private int LightIntensity;
	private int Battery;
	private int View;

	public synchronized boolean isLightToggle()
	{
		return LightToggle;
	}

	public synchronized void setLightToggle(boolean lightToggle)
	{
		LightToggle = lightToggle;
	}

	public synchronized int getLightIntensity()
	{
		return LightIntensity;
	}

	public synchronized void setLightIntensity(int lightIntensity)
	{
		LightIntensity = lightIntensity;
	}

	public synchronized int getBattery()
	{
		return Battery;
	}

	public synchronized void setBattery(int battery)
	{
		Battery = battery;
	}

	public synchronized int getView()
	{
		return View;
	}

	public synchronized void setView(int view)
	{
		this.View = view;
	}
}
