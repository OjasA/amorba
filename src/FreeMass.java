import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Color;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public class FreeMass extends Cell {
	public FreeMass(Point2D.Double theLocation, int xSpeed, int ySpeed, Color col) {
		super(20, theLocation, xSpeed, ySpeed, col);
	}
	public void moveAndDraw(Graphics2D g2d)
	{
		g2d.setColor(new Color(0,0,0,0)); //paints w/ background color to erase
		g2d.fillOval((int) Math.round(super.getLocation().getX() - super.getRadius()), (int) Math.round(super.getLocation().getY() - super.getRadius()), (int) super.getRadius() * 2, (int) super.getRadius() * 2); //erases current oval
		
		super.setLocation(super.getNewLocation());
		super.setNewLocation(super.getLocation());
		
		g2d.setColor(super.getColor());
		g2d.fillOval((int) Math.round(super.getLocation().getX() - super.getRadius()), (int) Math.round(super.getLocation().getY() - super.getRadius()), (int) super.getRadius() * 2, (int) super.getRadius() * 2); //draws new oval
		
		// draw outline
		if(this.getRadius() < 24){
			g2d.setStroke(new BasicStroke(3));
		}
		else{
			g2d.setStroke(new BasicStroke((int) (this.getRadius() / 8)));
		}
		g2d.setColor(super.getColor().darker());
		g2d.drawOval((int) (super.getLocation().getX() - super.getRadius()),
				(int) (super.getLocation().getY() - super.getRadius()),
				(int) (super.getRadius() * 2), (int) (super.getRadius() * 2));
	}
}
