import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

//This class is for preliminary testing purposes only.
//Some of this code can be eventually moved to the real server.

public class FakeServer {
	private double deltaX, deltaY;
	private Game game;
	private Thread serverThread;
	private Point position;
	private static int nextID = 0;

	// in the real server there will be a list of all cells
	private Player player; 
	/**
	 * An ArrayList<Cell> of all active food in the game
	 */
	private ArrayList<Cell> food = new ArrayList<Cell>();
	/**
	 * Amount of food in the game
	 */
	private int foodLimit = 2500;
	
	public FakeServer(Point location, Game g) {
		deltaX = deltaY = 0;
		game = g;
		for(int c = 0; c < foodLimit; c++){
			Cell tempFood = new Cell(5,(new Point2D.Double((int)(Math.random()*5000), (int)(Math.random()*5000))));
			tempFood.generateColor();
			food.add(tempFood);
		}
		player = new Player(15, new Point2D.Double((int)(Math.random() * 5000), (int)(Math.random() * 5000)));
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
			//game.setPlayer(player);
			if(food.size() <= foodLimit){
				Cell tempFood = new Cell(5,(new Point2D.Double((int)(Math.random()*5000), (int)(Math.random()*5000))));
				tempFood.generateColor();
				food.add(tempFood);
			}
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Point2D.Double calculateNewLocation() {
		double mult;
		if(player.getRadius() <= 250){
			mult = 0.65 - Math.pow(1.05, ((1/20)*player.getRadius())-20);
		}
		else{
			mult = 0.036;
		}
		mult = 1.0 / player.getRadius();
		double speed = 0;
		deltaX = position.getX() - game.getWidth() / 2;
		deltaY = position.getY() - game.getHeight() / 2;
		deltaY *= -1;
		
		if (deltaX == 0 && deltaY == 0)
		{
			return player.getLocation();
		}
		
		double distance = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
		if (distance > 3 * player.getRadius()) {
			distance = 3 * player.getRadius();
		}
		speed = distance * mult;
		double direction = Math.atan(deltaY / deltaX);
		if (deltaX < 0)
		{
			direction += Math.PI;
		}
		if (direction < 0)
		{
			direction += Math.PI * 2.0;
		}
		game.setTest(Double.toString(direction / Math.PI));
 
		
		double newDeltaX = Math.cos(direction) * speed;
		double newDeltaY = Math.sin(direction) * speed;
		
		
		game.setTest(Double.toString(newDeltaY));
		newDeltaY *= -1;
		return new Point2D.Double((player.getLocation().getX() + newDeltaX),
				(player.getLocation().getY() + newDeltaY));
		//return new Point(100, 100);
 
	}
	
	
	/**
	 * Check whether or not food has been eaten
	 */
	public void checkFood() {
		for(int c = 0; c < food.size(); c++) {
			double collisionCheck = Math.pow(((food.get(c).getRadius() + player.getRadius())),2);
			double xDiff = Math.pow(((food.get(c).getLocation().getX() - player.getLocation().getX())),2);
			double yDiff = Math.pow(((food.get(c).getLocation().getY() - player.getLocation().getY())),2);
			if((xDiff + yDiff) <= collisionCheck){
				player.addRadius(1);
				food.remove(c);
			}
		}
	}

	public Player getServerPlayer() {
		return player;
	}

	public void setPosition(Point p) {
		position = p;
	}
	
	/**
	 * Retrieve all food locations
	 * @return ArrayList of type food
	 */
	public ArrayList<Cell> getFood() {
		return food;
	}

	public void setFood(ArrayList<Cell> food) {
		this.food = food;
	}
	
	public static int getNewID() {
		return nextID++;
	}
	public static double roundToSignificantFigures(double num, int n) {
	    if(num == 0) {
	        return 0;
	    }

	    final double d = Math.ceil(Math.log10(num < 0 ? -num: num));
	    final int power = n - (int) d;

	    final double magnitude = Math.pow(10, power);
	    final long shifted = Math.round(num*magnitude);
	    return shifted/magnitude;
	}

}
