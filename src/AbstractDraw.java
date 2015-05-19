import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public abstract class AbstractDraw extends JPanel{
	
	public abstract void draw(Graphics2D g2d);
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);
		draw(g2d);
	}

}
