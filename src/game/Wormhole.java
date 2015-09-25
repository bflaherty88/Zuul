package game;

import java.util.Random;

public class Wormhole extends Room
{
	private static Random randomizer = new Random(System.currentTimeMillis());
	
	public Room getAdjacent(Direction d)
	{
		return allRooms.get(randomizer.nextInt(allRooms.size()));
	}
	
	public Room getNorth()
	{
		return allRooms.get(randomizer.nextInt(allRooms.size()));
	}
	
	public Room getEast()
	{
		return allRooms.get(randomizer.nextInt(allRooms.size()));
	}
	
	public Room getSouth()
	{
		return allRooms.get(randomizer.nextInt(allRooms.size()));
	}
	
	public Room getWest()
	{
		return allRooms.get(randomizer.nextInt(allRooms.size()));
	}
}
