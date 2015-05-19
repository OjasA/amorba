import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Window;

import javax.imageio.ImageIO;
import javax.swing.*;



public class Game extends JPanel implements KeyListener{
	private String name;
	private GameWindow window;
	public Game(String theName, GameWindow theWindow)
	{
		//get window this frame is being hosted in
		window = theWindow;
		
		//start key listener
		addKeyListener(this);
		
		//start game thread
		Thread gameThread = new Thread() {
			@Override
			public void run() {
				act();
			}
		};
		

		
	}
	//main game tick
	public void act()
	{
		try {
			Thread.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("pressed");
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			window.closeWindow();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
