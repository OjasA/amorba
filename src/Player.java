import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public class Player extends Cell {
	
	private String name;
	private int id;
	
	public Player(int theRadius, Point2D.Double theLocation) {
		super(theRadius, theLocation);
		name = "Amoeba";
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
		
		// font rendering
		AffineTransform affinetransform = new AffineTransform();    
		FontRenderContext frc = new FontRenderContext(affinetransform,true,true);    
		
		if((0.2126*getColor().getRed() + 0.7152*getColor().getGreen() + 0.0722*getColor().getBlue()) < 150){
			g2d.setColor(Color.WHITE);
		}
		else{
			g2d.setColor(Color.BLACK);
		}
		Font font = new Font("Segoe UI", Font.PLAIN,
				(int) (this.getRadius() * 0.4));
		int textwidth = (int) (font.getStringBounds(name, frc).getWidth());
		int textheight = (int) (font.getStringBounds(name, frc).getHeight());
		g2d.setFont(font);
		g2d.drawString(name,(int)this.getLocation().getX()-(textwidth/2),(int)this.getLocation().getY()+(textheight/4));
		
		Font smallFont = new Font("Segoe UI", Font.PLAIN,
				(int) (this.getRadius() * 0.2));
		int smallTextWidth = (int) (smallFont.getStringBounds("(#" + id + ")", frc).getWidth());
		int smallTextHeight = (int) (smallFont.getStringBounds("(#" + id + ")", frc).getHeight());
		g2d.setFont(smallFont);
		g2d.drawString("(#" + id + ")",(int)this.getLocation().getX()-(smallTextWidth/2),(int)(this.getLocation().getY()+(smallTextHeight/0.8)));
	}
	
	public void setName(String s)
	{
		name = s;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
