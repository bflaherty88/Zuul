package game;

public class Driver
{

	public static void main(String[] args)
	{
		Game.initialize();
		Game.mainGameLoop();
		Game.cleanup();
	}

}
