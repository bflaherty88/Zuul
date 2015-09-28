package game;

import java.util.Random;

public class Wormhole extends Room
{
	private static Random randomizer = new Random(System.currentTimeMillis());
	
	
	//Sends the item to a random room
	public void addItem(ZuulObject item)
	{
		allRooms.get(randomizer.nextInt(allRooms.size())).addItem(item);
	}
	
	//All getters return random rooms
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
	
	public void showNeighbors()
	{
		System.out.println("You can't seem to make out the boundaries of the room");
	}
}
