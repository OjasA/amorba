import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Player extends Cell {

	public Player(int theRadius, Point theLocation) {
		super(theRadius, theLocation);
	}
	
	public void moveAndDraw(Graphics2D g2d)
	{
		g2d.setColor(ConfigVariables.backgroundColor); //paints w/ background color to erase
		g2d.fillOval((int) super.getLocation().getX() - super.getRadius(), (int) super.getLocation().getY() - super.getRadius(), super.getRadius() * 2, super.getRadius() * 2); //erases current oval
		
		super.setLocation(super.getNewLocation());
		
		g2d.setColor(super.getColor());
		g2d.fillRect((int) super.getLocation().getX(), (int) super.getLocation().getY(), 1, 1);
		g2d.fillOval((int) super.getLocation().getX() - super.getRadius(), (int) super.getLocation().getY() - super.getRadius(), super.getRadius() * 2, super.getRadius() * 2); //draws new oval
	}
}
