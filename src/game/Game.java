package game;

public class Game 
{
	private static Player[] players;
	private static Room[] rooms;
	private static boolean exiting = false;
	
	public static void initialize(int playerCount)
	{
		initialize(playerCount, Level.getDefaultLevel());
	}
	
	public static void initialize(int playerCount, Level level)
	{
		rooms = level.getRooms();
		
		players = new Player[playerCount];
		
		for(int i = 0; i < playerCount; i++)
			players[i] = new Player(rooms[0]);	
		
		printWelcome();
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
	
	public static void mainGameLoop()
	{
		while(!exiting)
		{
			for(Player player : players)
			{
				player.update();
			}
		}
	}
	
	public static void exit()
	{
		exiting = true;
	}
	
	public static void cleanup()
	{
		System.out.println("Goodbye");
	}
}