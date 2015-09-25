package game;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Player extends Character
{
	public final static Direction[] directions = new Direction[]{	Direction.NORTH, Direction.EAST,
																	Direction.SOUTH, Direction.WEST};
	
	private Input action;
	private String object;
	private int currentDirection;
	private Room currentRoom;
	private static Scanner textIn = new Scanner(System.in);
	private static int count = 0;
	
	public Player(Room startingRoom)
	{
		currentRoom = startingRoom;
		inventory = new ArrayList<ZuulObject>();
		name = String.format("Player %d", ++count);
	}
	
	public void getInput()
	{
		System.out.println();
		
		if(count > 1)
			System.out.println(name + " take your turn:");
		
		String[] inputS = textIn.nextLine().toLowerCase().split(" ", 2);
		
		System.out.println();
		
		if(inputS.length > 1)
			object = inputS[1];
		
		switch(inputS[0])
		{
		case "go":
		case "move":
		case "walk":
			action = Input.MOVE;
			break;
		case "exit":
		case "quit":
			action = Input.EXIT;
			break;
		case "look":
		case "l":
			action = Input.LOOK;
			break;
		case "grab":
		case "pickup":
			action = Input.GRAB;
			break;
		case "drop":
			action = Input.DROP;
			break;
		case "inventory":
		case "i":
			action = Input.INVENTORY;
			break;
		case "equip":
			action = Input.EQUIP;
			break;
		case "use":
			action = Input.USE;
			break;
		default:
			action = Input.INVALID;
			break;
		}
		
	}

	public void update()
	{
		getInput();
		if(action == Input.INVALID)
			System.out.println("What does that even mean?");
		else
		{
			switch(action)
			{
			case EXIT:
				Game.exit();
				break;
			case MOVE:
				move();
				break;
			case LOOK:
				currentRoom.look();
				break;
			case GRAB:
				grab();
				break;
			case DROP:
				drop();
				break;
			case INVENTORY:
				checkInventory();
				break;
			case EQUIP:
				equip();
				break;
			case USE:
				use();
				break;
			default:
				System.out.println(name);
				break;
			}
		}
	}

	private void use()
	{
		ZuulObject item = searchInventory(object);
		if(item instanceof Consumable)
		{
			System.out.println("The " + object + " seems to have done nothing");
			inventory.remove(item);
		}
		else
			System.out.println("You can't use that");
		
	}

	private void equip()
	{
		ZuulObject item = searchInventory(object);
		
		if(item == null)
			System.out.println("You don't have one of those");
		else
		{
			if(item instanceof Weapon)
			{
				if(equipped != null)
					inventory.add(equipped);
				equipped = item;
				inventory.remove(item);
				System.out.println("You equipped a " + equipped);
			}
			else
			{
				System.out.println("You can't equip that");
				inventory.add(item);
			}
		}
	}

	private void checkInventory()
	{
		System.out.println("You have:\n");
		
		System.out.println("Equipped:");
		if(equipped == null)
			System.out.println("Nothing");
		else
			System.out.println(equipped);
		
		System.out.println("\nInventory:");
		if(inventory.isEmpty())
			System.out.println("Nothing");
		else
		{
			for(ZuulObject item : inventory)
				System.out.println(item);
		}
	}

	private void grab()
	{
		ZuulObject item = currentRoom.pickUp(object);
		if(item != null)
		{
			System.out.println("You picked up " + item);
			inventory.add(item);
		}
		else
			System.out.println("That's not in here");
	}
	
	private void drop()
	{
		ZuulObject item = searchInventory(object);
		
		if(item == null)
		{
			if(equipped.getName().equalsIgnoreCase(object))
			{
				currentRoom.addItem(item);
				inventory.remove(item);
				System.out.println("You dropped " + item);
			}
			else
				System.out.println("You don't have one of those");
		}
		else
		{
			currentRoom.addItem(item);
			inventory.remove(item);
			System.out.println("You dropped " + item);
		}
	}

	private void move()
	{
		boolean err = false;
		switch(object)
		{
		case "north":
			currentDirection = 0;
			break;
		case "east":
			currentDirection = 1;
			break;
		case "south":
			currentDirection = 2;
			break;
		case "west":
			currentDirection = 3;
			break;
		case "forward":
		case "straight":
		case "onward":
			break;
		case "right":
			currentDirection = (currentDirection + 1) % 4;
			break;
		case "backward":
		case "back":
			currentDirection = (currentDirection + 2) % 4;
			break;
		case "left":
			currentDirection = (currentDirection + 1) % 4;
			break;
		default:
			err = true;
			break;
		}
		
		if(currentRoom.getAdjacent(getCurrentDirection()) != null)
		{
			currentRoom = currentRoom.getAdjacent(getCurrentDirection());
			System.out.println("You go " + getCurrentDirection());
			if(currentRoom instanceof Wormhole)
				System.out.println("This room feels strange");
		}
		else
		{
			System.out.println("You can't go that way");
		}
	}
	
	private ZuulObject searchInventory(String itemName)
	{

		ListIterator<ZuulObject> it = inventory.listIterator();
		ZuulObject item = null;
		boolean done = false;
		while(it.hasNext() && !done)
		{
			item = it.next();
			if(item.getName().equalsIgnoreCase(itemName))
			{
				done = true;
			}
			else
				item = null;
		}
		
		return item;
	}

	private Direction getCurrentDirection()
	{
		return directions[currentDirection];
	}

}
