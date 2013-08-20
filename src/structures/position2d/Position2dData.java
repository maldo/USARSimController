package structures.position2d;

/**
 * 
 * @author Maldo
 */
public class Position2dData
{
	// position [m,m,rad] (x, y, yaw)
	private Pose2d pos;
	// translational velocities [m/s,m/s,rad/s] (x, y, yaw)
	private Pose2d vel;
	// Are the motors stalled?
	private byte stall;

	/**
	 * @return position [m,m,rad] (x, y, yaw)
	 */
	public synchronized Pose2d getPos()
	{
		return this.pos;
	}

	/**
	 * @param newPos
	 *            position [m,m,rad] (x, y, yaw)
	 */
	public synchronized void setPos(Pose2d newPos)
	{
		this.pos = newPos;
	}

	/**
	 * @return translational velocities [m/s,m/s,rad/s] (x, y, yaw)
	 */
	public synchronized Pose2d getVel()
	{
		return this.vel;
	}

	/**
	 * @param newVel
	 *            translational velocities [m/s,m/s,rad/s] (x, y, yaw)
	 */
	public synchronized void setVel(Pose2d newVel)
	{
		this.vel = newVel;
	}

	/**
	 * @return Are the motors stalled?
	 */
	public synchronized byte getStall()
	{
		return this.stall;
	}

	/**
	 * @param newStall
	 *            Are the motors stalled?
	 */
	public synchronized void setStall(byte newStall)
	{
		this.stall = newStall;
	}
}
