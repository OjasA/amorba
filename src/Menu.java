import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.*;


public class Menu extends AbstractDraw{
	public Menu()
	{
        this.setBackground(Color.white);
        JButton join = new JButton ("Start Game");
        join.setLocation(0, 0);
		this.add(join);
	}
	
	public void draw(Graphics2D g2d)
	{
		
	}
}
