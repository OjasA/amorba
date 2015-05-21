import java.awt.Point;

//This class is for preliminary testing purposes only.
//Some of this code can be eventually moved to the real server.


public class FakeServer {
private double deltaX, deltaY;
private Game game;
private Thread serverThread;

private Player player; //in the real server there will be a list of all the cells
	
	public FakeServer(Point location, Game g)
	{
		deltaX = deltaY = 0;
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
	
	public void setDeltas(double dx, double dy)
	{
		deltaX = dx;
		deltaY = dy;
	}
	
	public void act()
	{
		boolean running = true;
		while (running)
		{
			player.setNewLocation(calculateNewLocation());
			game.setPlayer(player);
			
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
		double speedMultiplier = 2.0 / player.getRadius();
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
		
		Point ans = new Point((int)newDeltaX, (int)newDeltaY);
		return ans;
	}
	

}
