package interfaces.touch;

import structures.touch.TouchData;

/**
 * 
 * @author Alberto Maldonado
 *
 */
public class TouchInterface
{

	private TouchData td;
	private boolean ready = false;

	public synchronized void readSensor(String sen)
	{
		String[] s = sen.split("\\} \\{");

		ready = false;

		td = new TouchData();

		String[] touch = s[1].split(" ");

		String last = touch[3];

		last = last.substring(0, last.length() - 1);

		td.setTouch(Boolean.parseBoolean(last));

		ready = true;
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

	public TouchData getData()
	{
		return this.td;
	}

}
