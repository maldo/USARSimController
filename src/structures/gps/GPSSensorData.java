package structures.gps;

import java.io.Serializable;

/**
 * 
 * @author Maldo
 */
public class GPSSensorData implements Serializable
{

	private static final long serialVersionUID = 3152003726678384291L;
	
	private int latitudeDeg;
	private float latitudeMin;
	private char latitudePos;
	private int longitudeDeg;
	private float longitudeMin;
	private char longitudePos;
	/** Signal (0 or 1) */
	private int fix;
	/** Number of satellites from sensor is getting signal */
	private int satellites;

	/**
	 * @return the latitudeDeg
	 */
	public synchronized int getLatitudeDeg()
	{
		return latitudeDeg;
	}

	/**
	 * @param latitudeDeg
	 *            the latitudeDeg to set
	 */
	public synchronized void setLatitudeDeg(int latitudeDeg)
	{
		this.latitudeDeg = latitudeDeg;
	}

	/**
	 * @return the latitudeMin
	 */
	public synchronized float getLatitudeMin()
	{
		return latitudeMin;
	}

	/**
	 * @param latitudeMin
	 *            the latitudeMin to set
	 */
	public synchronized void setLatitudeMin(float latitudeMin)
	{
		this.latitudeMin = latitudeMin;
	}

	/**
	 * @return the latitudePos
	 */
	public synchronized char getLatitudePos()
	{
		return latitudePos;
	}

	/**
	 * @param latitudePos
	 *            the latitudePos to set
	 */
	public synchronized void setLatitudePos(char latitudePos)
	{
		this.latitudePos = latitudePos;
	}

	/**
	 * @return the longitudeDeg
	 */
	public synchronized int getLongitudeDeg()
	{
		return longitudeDeg;
	}

	/**
	 * @param longitudeDeg
	 *            the longitudeDeg to set
	 */
	public synchronized void setLongitudeDeg(int longitudeDeg)
	{
		this.longitudeDeg = longitudeDeg;
	}

	/**
	 * @return the longitudeMin
	 */
	public synchronized float getLongitudeMin()
	{
		return longitudeMin;
	}

	/**
	 * @param longitudeMin
	 *            the longitudeMin to set
	 */
	public synchronized void setLongitudeMin(float longitudeMin)
	{
		this.longitudeMin = longitudeMin;
	}

	/**
	 * @return the longitudePos
	 */
	public synchronized char getLongitudePos()
	{
		return longitudePos;
	}

	/**
	 * @param longitudePos
	 *            the longitudePos to set
	 */
	public synchronized void setLongitudePos(char longitudePos)
	{
		this.longitudePos = longitudePos;
	}

	/**
	 * @return the fix
	 */
	public synchronized int getFix()
	{
		return fix;
	}

	/**
	 * @param fix
	 *            the fix to set
	 */
	public synchronized void setFix(int fix)
	{
		this.fix = fix;
	}

	/**
	 * @return the satellites
	 */
	public synchronized int getSatellites()
	{
		return satellites;
	}

	/**
	 * @param satellites
	 *            the satellites to set
	 */
	public synchronized void setSatellites(int satellites)
	{
		this.satellites = satellites;
	}
}