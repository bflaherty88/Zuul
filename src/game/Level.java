package game;

public class Level
{
	private Room[] rooms;
	private static final Room[] defaultRooms = new Room[]{
			new Room(), new Room(), new Wormhole(),
			new Room(), new Room(), new Room(),
			new Room(), new Room(), new Room()
	};
	
	public Level(Room[] rooms)
	{
		this.rooms = rooms;
	}
	
	//Default level is a row of eight rooms and one wormhole
	//it has a weapon, consumable and npc in it
	public static Level getDefaultLevel()
	{
		for(int i = 0; i < defaultRooms.length - 1; i ++)
			defaultRooms[i].setEast(defaultRooms[i+1]);
		
		defaultRooms[1].addItem(new Weapon("Rusty Sword", 1));
		defaultRooms[0].addItem(new Consumable("Health Potion", Consumable.Effect.HEALTH, 1));
		defaultRooms[2].addCharacter(new NPC("Generic Monster"));
		
		return new Level(defaultRooms);
	}
	
	public Room[] getRooms()
	{
		return rooms;
	}
}
