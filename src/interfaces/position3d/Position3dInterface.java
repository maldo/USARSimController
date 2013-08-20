package interfaces.position3d;

import interfaces.Client;
import structures.position3d.Pose3d;
import structures.position3d.Position3dData;
import structures.position3d.Position3dGeom;

/**
 * 
 * @author Alberto Maldonado
 *
 */
public class Position3dInterface
{

	private Position3dData pp3ddata;
	private boolean readyPp3ddata = false;
	private Position3dGeom pp3dgeom;
	private boolean readyPp3dgeom = false;
	private Client cl;

	/**
	 * Constructor for Position3DInterface.
	 * 
	 * @param pc
	 *            a reference to the PlayerClient object
	 */
	public Position3dInterface(Client cl)
	{
		this.cl = cl;
		pp3ddata = new Position3dData();
	}

	private void setVelocity(Pose3d vel, boolean stall)
	{
		pp3ddata.setVel(vel);

		if (stall)
		{
			pp3ddata.setStall(true);
		}
		else
		{
			pp3ddata.setStall(false);

			String m = String
					.format("DRIVE {AltitudeVelocity %f} {LinearVelocity %f} {LateralVelocity %f} {RotationalVelocity %f} {Normalized %b}\r\n",
							vel.getPpitch(), vel.getPx(), vel.getProll(),
							vel.getPyaw(), false);

			cl.addCommand(m);

		}
	}

	public void setSpeed(Pose3d vel)
	{
		setVelocity(vel, false);
	}

	public void setSpeed(float speed, float turnrate)
	{
		Pose3d pp = new Pose3d();
		pp.setPx(speed);
		pp.setPyaw(turnrate);
		setVelocity(pp, false);
	}

	public void setMotorPower(boolean stall)
	{
		setVelocity(pp3ddata.getVel(), stall);
	}

	public void ResetOdometry()
	{
		Pose3d pp = new Pose3d();
		pp3ddata.setPos(pp);
	}

	public void SetOdometry(float aX, float aY, float aZ, float aRoll,
			float aPitch, float aYaw)
	{
		Pose3d pp = new Pose3d();
		pp.setPx(aX);
		pp.setPy(aY);
		pp.setPz(aZ);
		pp.setProll(aRoll);
		pp.setPpitch(aPitch);
		pp.setPyaw(aYaw);
		pp3ddata.setPos(pp);
	}

	/**
	 * Get the Position3D data.
	 * 
	 * @return an object of type PlayerPosition3DData containing the requested
	 *         data
	 */
	public Position3dData getData()
	{
		return this.pp3ddata;
	}

	/**
	 * Get the geometry data.
	 * 
	 * @return an object of type PlayerPosition3DGeom containing the requested
	 *         data
	 */
	public Position3dGeom getGeom()
	{
		return this.pp3dgeom;
	}

	/**
	 * Check if data is available.
	 * 
	 * @return true if ready, false if not ready
	 */
	public boolean isDataReady()
	{
		if (readyPp3ddata)
		{
			readyPp3ddata = false;
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
		if (readyPp3dgeom)
		{
			readyPp3dgeom = false;
			return true;
		}
		return false;
	}

	// used by HeadingControl and PositionControl - to refactorize
	public double getX()
	{
		return this.pp3ddata.getPos().getPx();
	}

	public double getY()
	{
		return this.pp3ddata.getPos().getPy();
	}

	public double getZ()
	{
		return this.pp3ddata.getPos().getPx();
	}

	public double getYaw()
	{
		return (float) ((this.pp3ddata.getPos().getPyaw() * 180) / Math.PI);
	}

	public double getPitch()
	{
		return (float) ((this.pp3ddata.getPos().getPpitch() * 180) / Math.PI);
	}

	public double getRoll()
	{
		return (float) ((this.pp3ddata.getPos().getProll() * 180) / Math.PI);
	}

}