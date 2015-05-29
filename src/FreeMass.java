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
	public void moveAndDraw(Graphics2D g2d, Player player)
	{
		g2d.setColor(player.getColor());
		g2d.fillOval((int)this.getLocation().getX(), (int)this.getLocation().getY(), (int)this.getRadius(), (int)this.getRadius());
		g2d.setStroke(new BasicStroke(2));
	
		g2d.setColor(this.getColor().darker());
		g2d.drawOval((int)this.getLocation().getX(), (int)this.getLocation().getY(), (int)this.getRadius(), (int)this.getRadius());
	}
}
