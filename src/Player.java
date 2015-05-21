import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Player extends Cell {

	public Player(int theRadius, Point theLocation) {
		super(theRadius, theLocation);
	}
	
	public void moveAndDraw(Graphics2D g2d, Point destination)
	{
		g2d.setColor(ConfigVariables.backgroundColor); //paints w/ background color to erase
		g2d.fillOval((int) super.getLocation().getX() - super.getRadius(), (int) super.getLocation().getY() - super.getRadius(), super.getRadius(), super.getRadius()); //erases current oval
		
		super.setLocation(destination);
		
		g2d.setColor(super.getColor());
		g2d.fillOval((int) super.getLocation().getX() - super.getRadius(), (int) super.getLocation().getY() - super.getRadius(), super.getRadius(), super.getRadius()); //draws new oval
	}
}
