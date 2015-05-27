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
	private static int nextID = 0;

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
		player.setName(g.getName());

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
			player.setRadius(player.getRadius() - (player.getRadius() / 50000));
			game.setPlayer(player);
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public Point calculateNewLocation() {
		double mult;
		if(player.getRadius() <= 250){
			mult = 0.65 - Math.pow(1.05, ((1/20)*player.getRadius())-20);
		}
		else{
			mult = 0.036;
		}
		double speed = 0;
		deltaX = position.getX() - player.getLocation().getX();
		deltaY = position.getY() - player.getLocation().getY();
		double distance = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
		double frameWidth = game.getBounds().getWidth();
		double frameHeight = game.getBounds().getHeight();
		if (distance > 10) {
			distance = 10;
		}
		if(frameHeight < frameWidth){
			if(distance > frameHeight){
				distance = frameHeight;
			}
		}
		else if(frameHeight > frameWidth){
			if(distance > frameWidth){
				distance = frameWidth;
			}
		}
		speed = distance * mult;
		int horizontal, vertical;
		double slope = deltaY / deltaX;
 
		if (deltaX > 0) { // true means right, false means left
			horizontal = 1;
		} else if (deltaX == 0) {
			horizontal = 0;
		} else {
			horizontal = -1;
		}
 
		if (deltaY > 0) { // true means right, false means left
			vertical = 1;
		} else if (deltaY == 0) {
			vertical = 0;
		} else {
			vertical = -1;
		}
 
		double newDeltaX = 0;
		double newDeltaY = 0;
		if (horizontal == -1) {
			newDeltaX = -1 * Math.sqrt((speed * speed) / ((slope * slope) + 1));
			newDeltaY = (slope * newDeltaX);
		} else if (horizontal == 1) {
			newDeltaX = Math.sqrt((speed * speed) / ((slope * slope) + 1));
			newDeltaY = (slope * newDeltaX);
		} else if (horizontal == 0) {
			newDeltaX = 0;
			newDeltaY = vertical * speed;
		}
		return new Point((int) (player.getLocation().getX() + newDeltaX),
				(int) (player.getLocation().getY() + newDeltaY));
 
	}
	
	public void checkFood() {
		for(int c = 0; c < food.size(); c++) {
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
	
	public static int getNewID() {
		return nextID++;
	}

}
