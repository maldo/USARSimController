package interfaces.victim;

import java.util.Locale;

import interfaces.Utils;
import structures.Point;
import structures.victim.BodyPart;
import structures.victim.PartEnum;
import structures.victim.VictimData;

/**
 * 
 * @author Alberto Maldonado
 *
 */
public class VictimInterface
{

	/**
	 * SEN {Type VictSensor} {Name VictimSensor} {PartName Leg} {Location
	 * 2.05,0.33,0.46} {PartName Arm} {Location 2.51,0.44,0.39}
	 */

	private VictimData vd;
	private boolean ready = false;

	public synchronized void readSensor(String sen)
	{
		String[] s = sen.split("\\} \\{");
		
		ready = false;

		vd = new VictimData();

		vd.setName(s[1].split(" ")[1]);

		String status = Utils.partialString(s[2], "Status", "}", 0);

		if (status == "")
		{
			vd.setStatus(true);

			int x = s.length;

			x = s.length -(s.length - 2);
						
			for (int i = 0; i < s.length -2; i = i + 2)
			{
				//System.out.println("hola");
				
				BodyPart bp = new BodyPart();
				
				//System.out.println(s[x+i]);
								
				String partname = s[x+i].split(" ")[1];
								
				bp.setPart(PartEnum.valueOf(partname.toUpperCase(Locale.ENGLISH)));
				
				String[] location = s[x+1+i].split(",");
				String[] locx = location[0].split(" ");		
				String[] locz = location[2].split("}");
				
				Point l = new Point(locx[1], location[1], locz[0]);
				
				bp.setLocation(l);
				
				vd.setBodyPart(bp);
			}

		}
		else
		{
			vd.setStatus(false);
		}

		ready = true;
	}

	public VictimData getData()
	{
		return this.vd;
	}
	
	public boolean isReady()
	{
		if (ready)
		{
			ready = false;
			return true;
		}
		return false;
	}
	
	
}
