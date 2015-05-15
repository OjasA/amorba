import java.awt.Point;

public class FreeMass extends Cell {
	double speed;
	
	public FreeMass(Point theLocation, double s) {
		super(20, theLocation);
		speed = 100;
	}

}
