import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public abstract class AbstractDraw extends JPanel {

	public abstract void draw(Graphics2D g2d);

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.setRenderingHints(rh);
		super.paintComponent(g2d);
		draw(g2d);
	}

}
