import java.awt.Point;

public class Cell {
	private int size;
	private Point location;

	public Cell(int theSize, Point theLocation) {
		setSize(theSize);
		setLocation(theLocation);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void addSize(int size) {
		this.size += size;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}
}
