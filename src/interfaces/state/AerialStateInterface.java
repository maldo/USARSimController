package interfaces.state;

import interfaces.Utils;
import structures.state.AerialStateData;

/**
 * 
 * @author Alberto Maldonado
 *
 */
public class AerialStateInterface
{
	private AerialStateData as;
	private boolean ready = false;

	public synchronized void readSensor(String sen)
	{
		// sen = AerialVehicle} {Time 268.50} {LightToggle False} {LightIntensity 0} {Battery 1192} {View -1}

		
		ready = false;

		as = new AerialStateData();

		String ltoggle = Utils.partialString(sen, "LightToggle", "}",
				0);

		as.setLightToggle(Boolean.parseBoolean(ltoggle));

		String lint = Utils.partialString(sen, "LightIntensity", "}",
				0);

		as.setLightIntensity(Integer.parseInt(lint));

		String bat = Utils.partialString(sen, "Battery", "}", 0);

		as.setBattery(Integer.parseInt(bat));

		String view = Utils.partialString(sen, "View", "}", 0);

		as.setLightIntensity(Integer.parseInt(view));

		ready = true;

	}

	public AerialStateData getData()
	{
		return this.as;
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
