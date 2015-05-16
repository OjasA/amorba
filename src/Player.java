import java.awt.Color;
import java.awt.Point;

public class Player extends Cell {

	public Player(int theRadius, Point theLocation) {
		super(theRadius, theLocation);
	}
	public void Mitosis() {
		this.setRadius(this.getRadius() / 2);
		Player half = new Player(this.getRadius(),this.getLocation());
		half.setXSpeed(this.getXSpeed()*2); // sends the other half careening off ahead
		half.setYSpeed(this.getXSpeed()*2);
	}
}
