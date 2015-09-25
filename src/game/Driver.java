package game;

public class Driver
{

	public static void main(String[] args)
	{
		Game.initialize(1);
		Game.mainGameLoop();
		Game.cleanup();
	}

}
