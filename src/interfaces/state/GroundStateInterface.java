package interfaces.state;

import interfaces.Utils;
import structures.state.GroundStateData;

/**
 * 
 * @author Alberto Maldonado
 *
 */
public class GroundStateInterface
{
	private GroundStateData gs;
	private boolean ready = false;

	public synchronized void readSensor(String sen)
	{
		// sen = GroundVehicle} {Time 19.07} {FrontSteer 0.0000} {RearSteer
		// 0.0000} {LightToggle False} {LightIntensity 0} {Battery 1192} {View
		// -1}

		ready = false;

		gs = new GroundStateData();

		String fsteer = Utils
				.partialString(sen, "FrontSteer", "}", 0);

		gs.setFrontSteer(Float.parseFloat(fsteer));

		String rsteer = Utils.partialString(sen, "RearSteer", "}", 0);

		gs.setRearSteer(Float.parseFloat(rsteer));

		String ltoggle = Utils.partialString(sen, "LightToggle", "}",
				0);

		gs.setLightToggle(Boolean.parseBoolean(ltoggle));

		String lint = Utils.partialString(sen, "LightIntensity", "}",
				0);

		gs.setLightIntensity(Integer.parseInt(lint));

		String bat = Utils.partialString(sen, "Battery", "}", 0);

		gs.setBattery(Integer.parseInt(bat));

		String view = Utils.partialString(sen, "View", "}", 0);

		gs.setLightIntensity(Integer.parseInt(view));

		ready = true;

	}

	public GroundStateData getData()
	{
		return this.gs;
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
