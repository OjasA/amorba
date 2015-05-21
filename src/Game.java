import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Window;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Game extends AbstractDraw implements KeyListener {
	private String name;
	private GameWindow window;
	private boolean[] keys;
	private Point position;
	private Thread gameThread;
	
	private Player player;
	private Point newLocation;
	

	public Game(String theName, GameWindow theWindow) {
		//this will eventually come from server
		player = new Player(50, new Point(100, 100));
		newLocation = new Point(100, 100);
		
		// get window this frame is being hosted in
		window = theWindow;

		//key tracker
		keys = new boolean[525];
		
		// start key listener
		addKeyListener(this);
		
		//make Game panel focusable
		setFocusable(true);
		
		//start mouse listener
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e)
			{
				position = MouseInfo.getPointerInfo().getLocation();
			}
		});
		
		// start game thread
		gameThread = new Thread() {
			@Override
			public void run() {
				act();
			}
		};
		gameThread.start();

	}

	// main game tick
	public void act() {
		boolean running  = true;
		while(running)
		{
			//close window
			if (keys[KeyEvent.VK_ESCAPE])
			{
				window.closeWindow();
				running  = false;
			}
			
				
			//repaint
			repaint();
			
			//tickrate
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		player.moveAndDraw(g2d, newLocation);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	

}
