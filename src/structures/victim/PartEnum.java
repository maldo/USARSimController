package structures.victim;


public enum PartEnum
{
	ARM("Arm"), HAND("Hand"), CHEST("Chest"), PELVIS("Pelvis"), LEG("Leg"), FOOT("Foot");
	
	private String Part;
	
	PartEnum(String part)
	{
		this.Part = part;
	}
	
	public String getPart()
	{
		return Part;
	}
}
