package game;

import java.util.Scanner;

public class Game 
{
	private static Player[] players;
	private static Room[] rooms;
	private static boolean exiting = false;
	
	//Initializes from player count
	public static void initialize(int playerCount)
	{
		initialize(playerCount, Level.getDefaultLevel());
	}
	
	//initializes from player count and level
	public static void initialize(int playerCount, Level level)
	{
		rooms = level.getRooms();
		
		players = new Player[playerCount];
		
		for(int i = 0; i < playerCount; i++)
			players[i] = new Player(rooms[0]);	
		
		printWelcome();
	}
	
	//Gets user input for player count and initializes
	public static void initialize()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("How many players?");
		int count = 0;
		while(count == 0)
		{
			try
			{
				count = input.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("You have to enter a number");
				input.nextLine();
			}
		}
		initialize(count);
	}
	
	//Welcome statement taken from "Zuul Better"
	public static void printWelcome()
	{
		System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
	}
	
	//Updates players
	//This method is incomplete and should be improved
	public static void mainGameLoop()
	{
		while(!exiting)
		{
			for(Player player : players)
			{
				player.update();
				if(exiting) break;
			}
		}
	}
	
	//Sets status to exiting
	public static void exit()
	{
		exiting = true;
	}
	
	//Cleans up the game
	public static void cleanup()
	{
		System.out.println("Goodbye");
		Player.closeInput();
	}
}