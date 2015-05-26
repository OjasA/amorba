import java.awt.Point;
import java.util.ArrayList;

//This class is for preliminary testing purposes only.
//Some of this code can be eventually moved to the real server.

public class FakeServer {
	private double deltaX, deltaY;
	private Game game;
	private Thread serverThread;
	private Thread sizeReduce;
	private Point position;

	private Player player; // in the real server there will be a list of all the
							// cells
	private double trueMass;
	private ArrayList<Cell> food = new ArrayList<Cell>();
	public FakeServer(Point location, Game g) {
		deltaX = deltaY = 0;
		game = g;
		for(int c = 0; c < 2500; c++){
			Cell tempFood = new Cell(5,(new Point((int)(Math.random()*5000), (int)(Math.random()*5000))));
			tempFood.generateColor();
			food.add(tempFood);
		}
		player = new Player(15, new Point((int)(Math.random() * 5000), (int)(Math.random() * 5000)));
		player.generateColor();
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
			checkFood();
			// System.out.println(player.getNewLocation());
			player.setRadius(player.getRadius() - (player.getRadius() / 10000));
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
		/*
		System.out
				.println(player.getLocation() + " " + player.getNewLocation());
		*/
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
	
	public void checkFood() {
		for(int c = 0; c < food.size(); c++){
			Point locFood = food.get(c).getLocation();
			double collisionCheck = Math.pow(((food.get(c).getRadius() + player.getRadius())),2);
			double xDiff = Math.pow(((food.get(c).getLocation().getX() - player.getLocation().getX())),2);
			double yDiff = Math.pow(((food.get(c).getLocation().getY() - player.getLocation().getY())),2);
			if((xDiff + yDiff) <= collisionCheck){
				player.addRadius(1);
				food.remove(c);
				Cell tempFood = new Cell(5,(new Point((int)(Math.random()*5000), (int)(Math.random()*5000))));
				tempFood.generateColor();
				food.add(tempFood);
			}
		}
	}

	public Player getServerPlayer() {
		return player;
	}

	public void setPosition(Point p) {
		position = p;
	}

	public ArrayList<Cell> getFood() {
		return food;
	}

	public void setFood(ArrayList<Cell> food) {
		this.food = food;
	}

}
