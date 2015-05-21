import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Cell {
	private int radius;
	private Point location;
	private Point newLocation;
	private Color color;

	public Cell(int theradius, Point theLocation) {
		setRadius(theradius);
		setLocation(theLocation);
	}

	public Cell(int theradius, Point theLocation, int xSpeed, int ySpeed,
			Color color) {
		setRadius(theradius);
		setLocation(theLocation);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
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

	public void setNewLocation(Point l) {
		newLocation = l;
	}

	public Point getNewLocation() {
		return newLocation;
	}
}
