package game;

public class Weapon extends ZuulObject
{
	private int damage;
	
	public Weapon(String name, int damage)
	{
		this.name = name;
		this.damage = damage;
	}

	public int getDamage()
	{
		return damage;
	}
}
