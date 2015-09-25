package game;

public class Consumable extends ZuulObject
{
	enum Effect { HEALTH }
	
	public final Effect type;
	public final int magnitude;
	
	public Consumable(String name, Effect type, int magnitude)
	{
		this.name = name;
		this.type = type;
		this.magnitude = magnitude;
	}
	
	
}
