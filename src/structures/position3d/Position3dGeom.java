package structures.position3d;

public class Position3dGeom
{

	// Pose of the robot base, in the robot cs [m, m, m, rad, rad, rad].
	private Pose3d pose;
	// Dimensions of the base [m, m, m].
	private Bbox3d size;

	/**
	 * @return Pose of the robot base, in the robot cs [m, m, m, rad, rad, rad].
	 */
	public synchronized Pose3d getPose()
	{
		return this.pose;
	}

	/**
	 * @param newPose
	 *            Pose of the robot base, in the robot cs [m, m, m, rad, rad,
	 *            rad].
	 */
	public synchronized void setPose(Pose3d newPose)
	{
		this.pose = newPose;
	}

	/**
	 * @return Dimensions of the base [m, m, m].
	 */
	public synchronized Bbox3d getSize()
	{
		return this.size;
	}

	/**
	 * @param newSize
	 *            Dimensions of the base [m, m, m].
	 */
	public synchronized void setSize(Bbox3d newSize)
	{
		this.size = newSize;
	}
}