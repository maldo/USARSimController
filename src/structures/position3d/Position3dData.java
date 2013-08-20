package structures.position3d;

public class Position3dData
{

	// (x, y, z, roll, pitch, yaw) position [m, m, m, rad, rad, rad]
	private Pose3d pos;
	// (x, y, z, roll, pitch, yaw) velocity [m, m, m, rad, rad, rad]
	private Pose3d vel;
	// Are the motors stalled?
	private boolean stall;

	/**
	 * @return (x, y, z, roll, pitch, yaw) position [m, m, m, rad, rad, rad]
	 */
	public synchronized Pose3d getPos()
	{
		return this.pos;
	}

	/**
	 * @param newPos
	 *            (x, y, z, roll, pitch, yaw) position [m, m, m, rad, rad, rad]
	 */
	public synchronized void setPos(Pose3d newPos)
	{
		this.pos = newPos;
	}

	/**
	 * @return (x, y, z, roll, pitch, yaw) velocity [m, m, m, rad, rad, rad]
	 */
	public synchronized Pose3d getVel()
	{
		return this.vel;
	}

	/**
	 * @param newVel
	 *            (x, y, z, roll, pitch, yaw) velocity [m, m, m, rad, rad, rad]
	 */
	public synchronized void setVel(Pose3d newVel)
	{
		this.vel = newVel;
	}

	/**
	 * @return Are the motors stalled?
	 */
	public synchronized boolean getStall()
	{
		return this.stall;
	}

	/**
	 * @param newStall
	 *            Are the motors stalled?
	 */
	public synchronized void setStall(boolean newStall)
	{
		this.stall = newStall;
	}
}