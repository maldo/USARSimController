package structures.position3d;

/**
 * 
 * @author Maldo
 */
public class Bbox3d
{

	private float sw; // Width [m]
	private float sl; // Length [m]
	private float sh; // Height [m]

	/**
	 * @return Width [m]
	 */
	public synchronized float getSw()
	{
		return this.sw;
	}

	/**
	 * @param newSw
	 *            Width [m]
	 */
	public synchronized void setSw(float newSw)
	{
		this.sw = newSw;
	}

	/**
	 * @return Length [m]
	 */
	public synchronized float getSl()
	{
		return this.sl;
	}

	/**
	 * @param newSl
	 *            Length [m]
	 */
	public synchronized void setSl(float newSl)
	{
		this.sl = newSl;
	}

	/**
	 * @return Height [m]
	 */
	public synchronized float getSh()
	{
		return this.sh;
	}

	/**
	 * @param newSh
	 *            Height [m]
	 */
	public synchronized void setSh(float newSh)
	{
		this.sh = newSh;
	}
}
