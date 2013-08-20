package structures.co2;

/**
 * 
 * @author Maldo
 */
public class CO2SensorData
{

	private String Gas;
	private float Density;

	public synchronized float getDensity()
	{
		return Density;
	}

	public synchronized void setDensity(float Density)
	{
		this.Density = Density;
	}

	public synchronized String getGas()
	{
		return Gas;
	}

	public synchronized void setGas(String Gas)
	{
		this.Gas = Gas;
	}
}
