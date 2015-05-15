import java.awt.Color;
import java.awt.Point;

public class Player extends Cell {
	Color color;

	public Player(int theSize, Point theLocation, Color theColor) {
		super(theSize, theLocation);
		color = theColor;
	}
}
