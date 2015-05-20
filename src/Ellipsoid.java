import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;

/**
 * This is only an EXPERIMENTAL class meant to test out some of the game
 * functions. Not intended for use on the final product.
 * 
 * @author Harrison Tran
 *
 */
public class Ellipsoid extends MouseAdapter {
	private int xPos; // x position of the block
	private int yPos; // y position of the block
	private int radius;
	private Color color;
	
	public Ellipsoid(Game g) {
		// TODO Auto-generated constructor stub
		xPos = (g.getSize().width)/2;
		yPos = (g.getSize().height)/2;
		radius = 20;
		color = Color.blue;
	}
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void move(Graphics window, Point destination) {
		double deltaX = destination.getX() - getxPos();
		double deltaY = destination.getY() - getyPos();
		System.out.print("(" + deltaX + "," + deltaY + ")");
		double direction = (Math.atan(deltaY / deltaX));
		draw(window, Color.white);
		setxPos((int)(getxPos() + (1 * Math.cos(direction))));
		setxPos((int)(getyPos() + (1 * Math.cos(direction))));
		System.out.print("(" + xPos + "," + yPos + ")");
		draw(window);
	}
	public void draw(Graphics window)
	{
		window.setColor(color);
		window.fillOval(xPos-radius/2, yPos-radius/2, radius,radius);
	}
	public void draw(Graphics window, Color color)
	{
		window.setColor(color);
		window.fillOval(xPos-radius/2, yPos-radius/2, radius,radius);
	}
	
	

}
