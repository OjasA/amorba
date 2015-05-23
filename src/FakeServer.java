import java.awt.Point;

//This class is for preliminary testing purposes only.
//Some of this code can be eventually moved to the real server.

public class FakeServer {
	private double deltaX, deltaY;
	private Game game;
	private Thread serverThread;
	private Point position;

	private Player player; // in the real server there will be a list of all the
							// cells

	public FakeServer(Point location, Game g) {
		deltaX = deltaY = 0;
		game = g;
		player = new Player(15, new Point(100, 100));
		player.setNewLocation(player.getLocation());
		position = new Point(0, 0);

		serverThread = new Thread() {
			@Override
			public void run() {
				act();
			}
		};
		serverThread.start();
	}

	public void setDeltas(double dx, double dy) {
		deltaX = dx;
		deltaY = dy;
	}

	public void act() {
		boolean running = true;
		while (running) {
			player.setNewLocation(calculateNewLocation());
			System.out.println(player.getNewLocation());
			game.setPlayer(player);

			// server tickrate
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Point calculateNewLocation() {
		double speedMultiplier = 2.0 / player.getRadius();
		double direction = Math.atan(deltaY / deltaX);
		System.out
				.println(player.getLocation() + " " + player.getNewLocation());
		deltaX = position.getX() - player.getLocation().getX();
		deltaY = position.getY() - player.getLocation().getY();
		if (deltaX < 0)
			direction += Math.PI;
		double delta = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
		if (delta >= 200) {
			delta = 200;
		}

		double newDelta = (delta * speedMultiplier);
		double newDeltaX = (Math.cos(direction) * newDelta);
		double newDeltaY = (Math.sin(direction) * newDelta);

		if (newDeltaX < 0) {
			newDeltaX = 0;
		}
		if (newDeltaY < 0) {
			newDeltaY = 0;
		}

		Point ans = new Point((int) newDeltaX + (int) position.getX(),
				(int) newDeltaY + (int) position.getY());
		// return ans;
		return ans;
	}

	public Player getServerPlayer() {
		return player;
	}

	public void setPosition(Point p) {
		position = p;
	}

}
