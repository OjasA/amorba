import java.awt.Point;
import java.awt.Color;
import java.awt.geom.Point2D;

public class FreeMass extends Cell {

	public FreeMass(Point2D.Double theLocation, int xSpeed, int ySpeed, Color col) {
		super(20, theLocation, xSpeed, ySpeed, col);
	}

}
