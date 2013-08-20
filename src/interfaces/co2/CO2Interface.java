package interfaces.co2;

import interfaces.Utils;
import structures.co2.CO2SensorData;

/**
 * 
 * @author Alberto Maldonado
 */
public class CO2Interface
{

	private CO2SensorData co2;
	private boolean ready = false;

	public synchronized void readSensor(String sen)
	{
		/*
		 * str = "CO2Sensor} {Name CO2} {Gas CO2} {Density 0.00}"
		 */
		
		ready = false;
		
		co2 = new CO2SensorData();

		String fixstr = Utils.partialString(sen, "Gas",
				"}", 0);

		co2.setGas(fixstr);

		fixstr = Utils.partialString(sen, "Density",
				"}", 0);

		float density = Float.parseFloat(fixstr);

		co2.setDensity(density);

		ready = true;
	}

	public CO2SensorData getData()
	{
		return this.co2;
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
