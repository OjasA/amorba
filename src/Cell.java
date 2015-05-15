import java.awt.Graphics2D;
import java.awt.Point;

public class Cell extends AbstractDraw {
	private int radius;
	private Point location;
	private int xSpeed;
	private int ySpeed;

	public Cell(int theradius, Point theLocation , int xSpeed, int ySpeed) {
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
	
	public void getXSpeed(){
		return xSpeed;
	}
	
	public int setXSpeed(int x){
		this.xSpeed = x;
	}
	
	public void getYSpeed(){
		return ySpeed;
	}
	
	public int setYSpeed(int y){
		this.ySpeed = y;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}
}
