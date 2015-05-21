import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Cell {
	private int radius;
	private Point location;
	private int xSpeed;
	private int ySpeed;
	private Color color;

	public Cell(int theradius, Point theLocation) {
		setRadius(theradius);
		setLocation(theLocation);
		setXSpeed(0);
		setYSpeed(0);
	}

	public Cell(int theradius, Point theLocation, int xSpeed, int ySpeed,
			Color color) {
		setRadius(theradius);
		setLocation(theLocation);
		setXSpeed(xSpeed);
		setYSpeed(ySpeed);
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

	public int getXSpeed() {
		return xSpeed;
	}

	public void setXSpeed(int x) {
		this.xSpeed = x;
	}

	public int getYSpeed() {
		return ySpeed;
	}

	public void setYSpeed(int y) {
		this.ySpeed = y;
	}
	
	public void setColor(Color col) {
		color = col;
	}
	
	public Color getColor() {
		return color;
	}

}
