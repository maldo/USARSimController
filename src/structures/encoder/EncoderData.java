package structures.encoder;

/**
 * 
 * @author Maldo
 */
public class EncoderData
{

	private int ECLeftTick;
	private int ECRightTick;
	private int ECLeftBackTick;
	private int ECRightBackTick;

	public synchronized int getECLeftBackTick()
	{
		return ECLeftBackTick;
	}

	public synchronized void setECLeftBackTick(int ECLeftBackTick)
	{
		this.ECLeftBackTick = ECLeftBackTick;
	}

	public synchronized int getECLeftTick()
	{
		return ECLeftTick;
	}

	public synchronized void setECLeftTick(int ECLeftTick)
	{
		this.ECLeftTick = ECLeftTick;
	}

	public synchronized int getECRightBackTick()
	{
		return ECRightBackTick;
	}

	public synchronized void setECRightBackTick(int ECRightBackTick)
	{
		this.ECRightBackTick = ECRightBackTick;
	}

	public synchronized int getECRightTick()
	{
		return ECRightTick;
	}

	public synchronized void setECRightTick(int ECRightTick)
	{
		this.ECRightTick = ECRightTick;
	}
}
