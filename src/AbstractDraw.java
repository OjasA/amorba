import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public abstract class AbstractDraw extends JPanel {
	private BufferedImage buffer;
	public AbstractDraw(Window window)
	{
		buffer = new BufferedImage(window.getWidth(), window.getHeight(), BufferedImage.TYPE_INT_RGB);
	}
	
	public abstract void draw(Graphics2D g2d);

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Graphics2D g2 = (Graphics2D) buffer.getGraphics();
		// provide rendering hints to anti-alias the player
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHints(rh);
		super.paintComponent(g2);
		draw(g2);
		g2d.drawImage(buffer, 0, 0, this);
	}

}
