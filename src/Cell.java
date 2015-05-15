import java.awt.Graphics2D;
import java.awt.Point;

public class Cell extends AbstractDraw {
	private int radius;
	private Point location;

	public Cell(int theradius, Point theLocation) {
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

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}
}
