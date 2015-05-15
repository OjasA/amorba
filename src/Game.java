import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Window;

import javax.imageio.ImageIO;
import javax.swing.*;



public class Game extends JFrame{
	private String name;
	public Game(String theName)
	{
		//string parsing
		if (theName.matches(" *"))
		{
			name = "Amoeba";
		}
		else
		{
			name = theName;	
		}
		
		//main setup
		setTitle("Amorba");
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		
		//banner setup
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("icons/amorbaicon-bmp-small.png")); // read image
																			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		setIconImage(img);
		//go back to menu when closing
		addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				new Menu();
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		
	}
}
