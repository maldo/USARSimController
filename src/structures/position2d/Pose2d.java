package structures.position2d;

/**
 * 
 * @author Maldo
 */
public class Pose2d
{

	private float px; // X [m]
	private float py; // Y [m]
	private float pa; // yaw [rad]

	public Pose2d() {
		this.px = 0;
		this.py = 0;
		this.pa = 0;
	}

	public Pose2d(float x, float y, float a) {
		this.px = x;
		this.py = y;
		this.pa = a;
	}

	/**
	 * @return X [m]
	 */
	public synchronized float getPx()
	{
		return this.px;
	}

	/**
	 * @param newPx
	 *            X [m]
	 */
	public synchronized void setPx(float newPx)
	{
		this.px = newPx;
	}

	/**
	 * @return Y [m]
	 */
	public synchronized float getPy()
	{
		return this.py;
	}

	/**
	 * @param newPy
	 *            Y [m]
	 */
	public synchronized void setPy(float newPy)
	{
		this.py = newPy;
	}

	/**
	 * @return yaw [rad]
	 */
	public synchronized float getPa()
	{
		return this.pa;
	}

	/**
	 * @param newPa
	 *            yaw [rad]
	 */
	public synchronized void setPa(float newPa)
	{
		this.pa = newPa;
	}
}
