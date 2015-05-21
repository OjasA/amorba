import java.awt.Point;

//This class is for preliminary testing purposes only.
//Some of this code can be eventually moved to the real server.


public class FakeServer {
private Point pointerLocation;
private Game game;
private Thread serverThread;

private Player player; //in the real server there will be a list of all the cells
	
	public FakeServer(Point location, Game g)
	{
		pointerLocation = location;
		game = g;
		player = new Player(20, new Point(100, 100));
		
		serverThread = new Thread() {
			@Override
			public void run() {
				act();
			}
		};
		serverThread.start();
	}
	
	public void setPointerLocation(Point location)
	{
		pointerLocation = location;
	}
	
	public void act()
	{
		boolean running = true;
		while (running)
		{
			game.setPlayer(player);
			game.setNewLocation(calculateNewLocation());
			
			//server tickrate
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Point calculateNewLocation()
	{
		return new Point(100, 100); //temporary code
	}
	

}
