package game;

import java.util.List;

public abstract class Character
{
	protected String name;
	protected ZuulObject equipped;
	protected List<ZuulObject> inventory;
	
	public abstract void update();
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return name;
	}
}
