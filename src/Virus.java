import java.awt.Point;

public class Virus extends Cell {

	public Virus(Point location) {
		super(80, location);
	}
	
	public Virus(int size, Point location) {
		super(size,location);
	}
	
	/**
	 * Divides the virus into two if the virus is too large.
	 */
	public void virusSplit() {
		if(this.getRadius() > 200) {
			this.setRadius(100);
			Virus splitVirus = new Virus(100, new Point());
		}
	}

}
