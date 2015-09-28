package game;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Room
{
	private Room north, east, south, west;
	private List<ZuulObject> items = new ArrayList<ZuulObject>();
	private List<Character> characters = new ArrayList<Character>();
	protected static List<Room> allRooms = new ArrayList<Room>();

	public Room(Room north, Room east, Room south, Room west)
	{
		this.north = north;
		this.east = east;
		this.south = south;
		this.west = west;
		allRooms.add(this);
	}
	
	public Room()
	{
		allRooms.add(this);
	}

	public Room getAdjacent(Direction object)
	{
		switch(object)
		{
		case NORTH:
			return north;
		case SOUTH:
			return south;
		case EAST:
			return east;
		case WEST:
			return west;
		default:
			return null;
		}
	}

	public Room getNorth()
	{
		return north;
	}

	public void setNorth(Room north)
	{
		this.north = north;
		if(north.getSouth() != this)
			north.setSouth(this);
	}

	public Room getEast()
	{
		return east;
	}

	public void setEast(Room east)
	{
		this.east = east;
		if(east.getWest() != this)
			east.setWest(this);
	}

	public Room getSouth()
	{
		return south;
	}

	public void setSouth(Room south)
	{
		this.south = south;
		if(south.getNorth() != this)
			south.setNorth(this);
	}

	public Room getWest()
	{
		return west;
	}

	public void setWest(Room west)
	{
		this.west = west;
		if(west.getEast() != this)
			west.setEast(this);
	}
	
	public void addCharacter(Character character)
	{
		characters.add(character);
	}
	
	public void removeCharacter(Character character)
	{
		characters.remove(character);
	}
	
	public void addItem(ZuulObject item)
	{
		items.add(item);
	}
	
	public void removeItem(ZuulObject item)
	{
		items.remove(item);
	}

	//Prints a list of the rooms contents
	public void look()
	{
		System.out.println("You see:");

		showNeighbors();
		
		for(Character character : characters)
			System.out.println(character);
		for(ZuulObject item : items)
			System.out.println(item);
		
	}
	
	//Prints a list of rooms in different directions
	public void showNeighbors()
	{
		if(north != null)
			System.out.println("A room to the north");
		if(south != null)
			System.out.println("A room to the south");
		if(east != null)
			System.out.println("A room to the east");
		if(west != null)
			System.out.println("A room to the west");
	}

	//Removes and returns an item from the room
	public ZuulObject pickUp(String object)
	{
		ListIterator<ZuulObject> it = items.listIterator();
		ZuulObject item = null;
		boolean done = false;
		while(it.hasNext() && !done)
		{
			item = it.next();
			if(item.getName().equalsIgnoreCase(object))
			{
				it.remove();
				done = true;
			}
			else
				item = null;
		}
		return item;
	}
}
