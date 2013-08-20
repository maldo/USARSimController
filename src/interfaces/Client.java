package interfaces;

import interfaces.HMD.HMDInterface;
import interfaces.RFIDTag.RFIDTagInterface;
import interfaces.co2.CO2Interface;
import interfaces.gps.GPSInterface;
import interfaces.groundtruth.GroundTruthInterface;
import interfaces.ins.InsInterface;
import interfaces.laser.LaserInterface;
import interfaces.odometry.OdometryInterface;
import interfaces.position2d.Position2dInterface;
import interfaces.position3d.Position3dInterface;
import interfaces.sonar.SonarInterface;
import interfaces.sound.SoundInterface;
import interfaces.state.AerialStateInterface;
import interfaces.state.GroundStateInterface;
import interfaces.touch.TouchInterface;
import interfaces.victim.VictimInterface;

import java.util.LinkedList;
import java.util.Queue;

import structures.Point;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * 
 * @author Alberto Maldonado
 *
 */
public class Client extends Thread
{

	private Socket socket = null;
	private DataInputStream is = null;
	private DataOutputStream os = null;
	private BufferedOutputStream buffer = null;
	private BufferedReader br = null;

	private Queue<String> data = null;
	boolean newc = false;

	private CO2Interface co2 = new CO2Interface();
	private GPSInterface gps = new GPSInterface();
	private GroundTruthInterface gt = new GroundTruthInterface();
	private HMDInterface hmd = new HMDInterface();
	private InsInterface ins = new InsInterface();
	private LaserInterface laser = new LaserInterface();
	private OdometryInterface od = new OdometryInterface();
	private RFIDTagInterface rfid = new RFIDTagInterface();
	private SonarInterface sonar = new SonarInterface();
	private SoundInterface sound = new SoundInterface();
	private TouchInterface touch = new TouchInterface();
	private VictimInterface vict = new VictimInterface();

	private GroundStateInterface gsi = new GroundStateInterface();
	private AerialStateInterface asi = new AerialStateInterface();
	private Position2dInterface p2d = new Position2dInterface(this);
	private Position3dInterface p3d = new Position3dInterface(this);
	
	/**
	 * Creates the connection between User program and USARSim
	 * 
	 * @param host Where USARSin is
	 * @param port Which port USARSim is using
	 * @param type Which type of robot is create in USARSim
	 * @param id Robot Id
	 * @param location Initial location of the robot inside USARSim scenario
	 */
	public Client(String host, int port, String type, String id, Point location)
	{
		try
		{
			socket = new Socket(host, port);
			is = new DataInputStream(socket.getInputStream());
			buffer = new BufferedOutputStream(socket.getOutputStream(), 128);
			os = new DataOutputStream(new DataOutputStream(buffer));

			br = new BufferedReader(new InputStreamReader(is));

			data = new LinkedList<String>();
			
			SpawnRobot(type, id, location);
			
			startRobot();			
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * Spawns the robot into USARSim environment
	 * 
	 * @param type which robot is
	 * @param id robot identification 
	 * @param location location inside USARSim
	 */
	public void SpawnRobot(String type, String id, Point location)
	{
		try
		{
			String t = "USARBot." + type;

			String m = String
					.format("INIT {ClassName %s} {Name %s} {Location %f %f %f} {Rotation %f %f %f}\r\n",
							t, id, location.getX(), location.getY(), location.getZ(), 0.0,
							0.0, 0.0);
			os.writeBytes(m);
			os.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Sends a command to USARSim to get all data
	 */
	public void startRobot()
	{
		try
		{
			os.writeBytes("GETCONF {Type Robot}\r\n");
			os.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Close connection between Client and USARSim
	 */
	void close()
	{
		try
		{
			buffer.close();
			os.close();
			is.close();
			socket.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 *  
	 * @return if there is data available in the reading socket
	 */
	public boolean isDataAvailable()
	{
		try
		{
			return is.read() > 0;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * It is used in order to keep up the connection between client and USARSim
	 */
	public void run()
	{
		while (isDataAvailable())
		{		
			readData();

			if (newc)
			{
				sendData();
				newc = false;
			}
		}

		close();
	}

	synchronized void readData()
	{
		// SEN {Time 0.000} {Type GPS} {Name string } {Latitude int , float ,
		// char} {Longitude int , float , char} {Fix int} {Satellites int}

		// SEN {Time 7.9358} {Type GroundTruth} {Name GroundTruth} {Location
		// 4.70,1.90,2.05} {Orientation 6.28,0.00,6.21}

		
		
		try
		{
			String x = br.readLine();

			// x =
			// "SEN {Type GPS} {Name GPS1} {Latitude 47,40.3323,N} {Longitude 122,18.5977,W} {Fix 1} {Satellites 8}";

			// br.wait(10);
			/*
			 * char[] buf = new char[256];
			 * 
			 * d.read(buf);
			 * 
			 * String x = String.valueOf(buf);
			 */

			System.out.println(x);

			// FIXME SEN/EN
			if (x.startsWith("SEN"))
			{
				// Field Time optional depends on bTimeStamp at Usar
				String time = Utils.partialString(x, "Time", "}", 0);

				if (time != "")
				{
					System.err.println(time);
				}

				// Field Type is mandatory
				String type = Utils.partialString(x, "Type", "}", 0);

				if (Utils.Debug) System.err.println(type);

				if (type.compareTo("CO2Sensor") == 0)
				{
					co2.readSensor(x.substring(x.indexOf(type)));
				}
				else if (type.compareTo("GPS") == 0)
				{
					gps.readSensor(x.substring(x.indexOf(type)));
				}
				else if (type.compareTo("GroundTruth") == 0)
				{
					gt.readSensor(x.substring(x.indexOf(type)));
				}
				else if (type.compareTo("HumanMotion") == 0)
				{
					hmd.readSensor(x.substring(x.indexOf(type)));
				}
				else if (type.compareTo("INS") == 0)
				{
					ins.readSensor(x.substring(x.indexOf(type)));
				}
				else if (type.compareTo("RangeScanner") == 0)
				{
					laser.readSensor(x.substring(x.indexOf(type)));
				}
				else if (type.compareTo("Odometry") == 0)
				{
					od.readSensor(x.substring(x.indexOf(type)));
				}
				else if (type.compareTo("RFIDTag") == 0)
				{
					rfid.readSensor(x.substring(x.indexOf(type)));
				}
				else if (type.compareTo("Sonar") == 0)
				{
					sonar.readSensor(x.substring(x.indexOf(type)));
				}
				else if (type.compareTo("Sound") == 0)
				{
					sound.readSensor(x.substring(x.indexOf(type)));
				}
				else if (type.compareTo("Touch") == 0)
				{
					touch.readSensor(x.substring(x.indexOf(type)));
				}
				else if (type.compareTo("VictSensor") == 0)
				{
					vict.readSensor(x.substring(x.indexOf(type)));
				}
			}
			else if (x.startsWith("STA"))
			{
				String type = Utils.partialString(x, "Type", "}", 0);

				if (type.compareTo("GroundVehicle") == 0)
				{
					gsi.readSensor(x.substring(x.indexOf(type)));
				}
				else if (type.compareTo("AerialVehicle") == 0)
				{
					asi.readSensor(x.substring(x.indexOf(type)));
				}

			}
			else if (x.startsWith("MISSTA"))
			{

			}
			else if (x.startsWith("CONF"))
			{

			}
			else if (x.startsWith("RES"))
			{

			}
			else if (x.startsWith("GEO"))
			{

			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Sends commands to USARSim
	 * 
	 */
	synchronized void sendData()
	{
		while (!data.isEmpty())
		{
			try
			{
				String x = data.poll();

				os.writeBytes(x);
				os.flush();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Add the command to the queue in order to be sent
	 * 
	 * @param x USARSim Command
	 */
	public synchronized void addCommand(String x)
	{
		data.add(x);
		newc = true;	
	}

	/**
	 * Returns the current CO2 Interface
	 * 
	 * @return CO2Interface
	 */
	public CO2Interface requestCO2Interface()
	{
		return this.co2;
	}

	/**
	 * Returns the current GPS Interface
	 * 
	 * @return GPSInterface
	 */
	public GPSInterface requestGpsInterface()
	{
		return this.gps;
	}

	/**
	 * Returns the current GroundTruth Interface
	 * 
	 * @return GroundTruthInterface
	 */
	public GroundTruthInterface requestGroundTruthInterface()
	{
		return this.gt;
	}

	/**
	 * Returns the current Human Motion Detection Interface
	 * 
	 * @return HMDInterface
	 */
	public HMDInterface requestHmdInterface()
	{
		return this.hmd;
	}

	/**
	 * Returns the current INS Interface
	 * 
	 * @return INSInterface
	 */
	public InsInterface requestInsInterface()
	{
		return this.ins;
	}

	/**
	 * Returns the current Laser Interface
	 * 
	 * @return LaserInterface
	 */
	public LaserInterface requestLaserInterface()
	{
		return this.laser;
	}

	/**
	 * Returns the current Odometry Interface
	 * 
	 * @return OdometryInterface
	 */
	public OdometryInterface requestOdometryInterface()
	{
		return this.od;
	}

	/**
	 * Returns the current RFID Tag Interface
	 * 
	 * @return RFIDTagInterface
	 */
	public RFIDTagInterface requestRfidTagInterface()
	{
		return this.rfid;
	}

	/**
	 * Returns the current Sonar Interface
	 * 
	 * @return SonarInterface
	 */
	public SonarInterface requestSonarInterface()
	{
		return this.sonar;
	}

	/**
	 * Returns the current Sound Interface
	 *  
	 * @return SoundInterface
	 */
	public SoundInterface requestSoundInterface()
	{
		return this.sound;
	}

	/**
	 * Returns the current Touch Interface
	 * 
	 * @return TouchInterface
	 */
	public TouchInterface requestTouchInterface()
	{
		return this.touch;
	}

	/**
	 * Returns the current Victim Interface 
	 * 
	 * @return VictimInterface
	 */
	public VictimInterface requestVictimInterface()
	{
		return this.vict;
	}

	/**
	 * Returns the current GroundState Interface
	 * 
	 * @return GroundStateInterface
	 */
	public GroundStateInterface requestGroundStateInterface()
	{
		return this.gsi;
	}

	/**
	 * Returns the current AerialState Interface
	 * 
	 * @return AerialStateInterface
	 */
	public AerialStateInterface requestAerialStateInterface()
	{
		return this.asi;
	}

	/**
	 * Returns the current Position2d Interface
	 * 
	 * @return Position2dInterface
	 */
	public Position2dInterface requestPosition2dInterface()
	{
		return this.p2d;
	}
	
	/**
	 * Returns the current Position3d Interface
	 * 
	 * @return Position3dInterface
	 */
	public Position3dInterface requestPosition3dInterface()
	{
		return this.p3d;
	}
}
