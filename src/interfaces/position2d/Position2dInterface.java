package interfaces.position2d;

import structures.position2d.Pose2d;
import structures.position2d.Position2dData;
import structures.position2d.Position2dGeom;
import interfaces.Client;

/**
 * 
 * @author Alberto Maldonado
 */
public class Position2dInterface
{

	
	private Position2dData p2dData;
	private boolean readyPp2ddata = false;
	private Position2dGeom p2dGeom;
	private boolean readyPp2dgeom = false;
	private boolean enable = true;
	private Client cl;
	
	public Position2dInterface(Client cl)
	{
		this.cl = cl;
		p2dData = new Position2dData();
	}
	
	/**
	 * 
	 * @param speedX speed for left wheel
	 * @param speedY speed for right wheel
	 */
	public void setSpeed(float speedX, float speedY)
	{
		Pose2d pp = new Pose2d();
		pp.setPx(speedX);
		pp.setPy(speedY);
		setVelocity(pp);
	}

	public void setSpeed(float speedX, float speedY, float turnRate)
	{
		Pose2d pp = new Pose2d();
		pp.setPx(speedX);
		pp.setPy(speedY);
		pp.setPa(turnRate);
		setVelocity(pp);
	}

	public void setSpeed(Pose2d vel)
	{
		setVelocity(vel);
	}

	private void setVelocity(Pose2d vel)
	{
		p2dData.setPos(vel);
		
		if (enable)
		{
			String m = String.format("DRIVE {Left %f} {Right %f} {Normalized %b}\r\n", vel.getPx(), vel.getPy(), false);
			cl.addCommand(m);
		}
		else
		{
			
		}		
	}

	public void setCarLike(float velocity, float angle)
	{
		setSpeed(velocity, angle);
	}

	public void GoTo(Pose2d pos, Pose2d vel)
	{

	}

	public void GoTo(Pose2d pos)
	{

	}

	public void GoTo(double aX, double aY, double aYaw)
	{

	}

	/**
	 * Configuration request: Motor power. <br>
	 * <br>
	 * On some robots, the motor power can be turned on and off from software. <br>
	 * <br>
	 * Be VERY careful with this command! You are very likely to start the robot
	 * running across the room at high speed with the battery charger still
	 * attached.
	 * 
	 * @param state
	 *            0 for off, 1 for on
	 */
	public void setMotorEnable(boolean enable)
	{
		this.enable = enable;
	}

	/**
	 * Configuration request: Reset odometry. <br>
	 * <br>
	 * Resets the robot's odometry to (x,y,theta) = (0,0,0).
	 */
	public void resetOdometry()
	{
		Pose2d p2d = new Pose2d();
		p2dData.setPos(p2d);
	}

	/**
	 * Configuration request: Set odometry.
	 * 
	 * @param pose
	 *            (x, y, yaw) [m, m, rad]
	 */
	public void setOdometry(Pose2d pose)
	{
		p2dData.setPos(pose);
	}

	/**
	 * Get the Position2D data.
	 * 
	 * @return an object of type PlayerPosition2DData containing the requested
	 *         data
	 */
	public Position2dData getData()
	{
		return this.p2dData;
	}

	/**
	 * Get the geometry data.
	 * 
	 * @return an object of type PlayerPosition2DGeom containing the requested
	 *         data
	 */
	public Position2dGeom getGeom()
	{
		return this.p2dGeom;
	}

	/**
	 * Check if data is available.
	 * 
	 * @return true if ready, false if not ready
	 */
	public boolean isDataReady()
	{
		if (readyPp2ddata)
		{
			readyPp2ddata = false;
			return true;
		}
		return false;
	}

	/**
	 * Check if geometry data is available.
	 * 
	 * @return true if ready, false if not ready
	 */
	public boolean isGeomReady()
	{
		if (readyPp2dgeom)
		{
			readyPp2dgeom = false;
			return true;
		}
		return false;
	}

	// used by HeadingControl and PositionControl - to refactorize
	public double getX()
	{
		return this.p2dData.getPos().getPx();
	}

	public double getY()
	{
		return this.p2dData.getPos().getPy();
	}

	public double getYaw()
	{
		return this.p2dData.getPos().getPa();
	}
}
