import java.awt.Point;

public class Virus extends Cell {

	public Virus(Point location) {
		super(80, location);
	}
	
	public Virus(int size, Point location) {
		super(size,location);
	}
	
	public void virusSplit() {
		if(this.getSize() > 200) {
			this.setSize(100);
			Virus splitVirus = new Virus(100, new Point());
		}
	}

}
