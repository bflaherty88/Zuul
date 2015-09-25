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
		
		System.out.println("Hello");
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
