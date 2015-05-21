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
		player = new Player(15, new Point(100, 100));
		
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
		double speedMultiplier = 1.0 / player.getRadius();
		int deltaX = (int) (pointerLocation.getX() - player.getLocation().getX());
		int deltaY = (int) (pointerLocation.getY() - player.getLocation().getY());
		double direction = Math.atan(deltaY / deltaX);
		if (deltaX < 0)
			direction += Math.PI;
		double delta = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
		if (delta >= 200)
		{
			delta = 200;
		}

		double newDelta = (delta * speedMultiplier);
		double newDeltaX = (Math.cos(direction) * newDelta);
		double newDeltaY = (Math.sin(direction) * newDelta);
		
		return new Point((int)newDeltaX, (int)newDeltaY); //temporary code
	}
	

}
