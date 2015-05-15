import java.awt.Point;
import java.awt.Color;

public class FreeMass extends Cell {
	private Color color;
	
	public FreeMass(Point theLocation, int xSpeed, int ySpeed, Color col) {
		super(20, theLocation, xSpeed, ySpeed);
		color = col;
	}
	

}
