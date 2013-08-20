package structures.position3d;

/**
 * 
 * @author Maldo
 */
public class Pose3d
{

	private float px; // X [m]
	private float py; // Y [m]
	private float pz; // Z [m]
	private float proll; // roll [rad]
	private float ppitch; // pitch [rad]
	private float pyaw; // yaw [rad]

	public Pose3d()
	{
		
	}
	
	public Pose3d(float ppitch, float px, float proll)
	{
		this.ppitch = ppitch;
		this.px = px;
		this.proll = proll;
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
	 * @return Z [m]
	 */
	public synchronized float getPz()
	{
		return this.pz;
	}

	/**
	 * @param newPz
	 *            Z [m]
	 */
	public synchronized void setPz(float newPz)
	{
		this.pz = newPz;
	}

	/**
	 * @return roll [rad]
	 */
	public synchronized float getProll()
	{
		return this.proll;
	}

	/**
	 * @param newProll
	 *            roll [rad]
	 */
	public synchronized void setProll(float newProll)
	{
		this.proll = newProll;
	}

	/**
	 * @return pitch [rad]
	 */
	public synchronized float getPpitch()
	{
		return this.ppitch;
	}

	/**
	 * @param newPpitch
	 *            pitch [rad]
	 */
	public synchronized void setPpitch(float newPpitch)
	{
		this.ppitch = newPpitch;
	}

	/**
	 * @return yaw [rad]
	 */
	public synchronized float getPyaw()
	{
		return this.pyaw;
	}

	/**
	 * @param newPyaw
	 *            yaw [rad]
	 */
	public synchronized void setPyaw(float newPyaw)
	{
		this.pyaw = newPyaw;
	}
}
