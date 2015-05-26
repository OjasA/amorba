import java.awt.Color;
import java.awt.Point;

public class Cell {
	private double radius;
	private Point location;
	private Point newLocation;
	private Color color;

	public Cell(int theradius, Point theLocation) {
		setRadius(theradius);
		setLocation(theLocation);
	}

	public Cell(int theradius, Point theLocation, Color color) {
		setRadius(theradius);
		setLocation(theLocation);
		setColor(color);
	}

	public Cell(int i, Point theLocation, int xSpeed, int ySpeed, Color col) {
		setRadius(i);
		setLocation(theLocation);
		setColor(col);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void addRadius(int radius) {
		this.radius += radius;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public void setColor(Color col) {
		color = col;
	}

	public Color getColor() {
		return color;
	}
	public void generateColor() {
		float red = (float) Math.random();
		float green = (float) Math.random();
		float blue = (float) Math.random();
		Color rgb = new Color(red,green,blue);
		color = rgb;
	}
	/**
	 * Sets a new position for the cell according to argument Point l
	 * @param l The new location of the cell.
	 */
	public void setNewLocation(Point l) {
		newLocation = l;
		if (l.getX() < 0) {
			newLocation.setLocation(0, newLocation.getY());
		}
		if (l.getY() < 0) {
			newLocation.setLocation(newLocation.getX(), 0);
		}
		if (l.getX() > Game.getBoardSize()) {
			newLocation.setLocation(Game.getBoardSize(), newLocation.getY());
		}
		if (l.getY() > Game.getBoardSize()) {
			newLocation.setLocation(newLocation.getX(), Game.getBoardSize());
		}
	}

	public Point getNewLocation() {
		return newLocation;
	}
}
