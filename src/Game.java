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

public class Game extends AbstractDraw implements KeyListener {
	private String name;
	private GameWindow window;
	private boolean[] keys;
	private Thread gameThread;

	public Game(String theName, GameWindow theWindow) {
		// get window this frame is being hosted in
		window = theWindow;

		//key tracker
		keys = new boolean[525];
		
		// start key listener
		addKeyListener(this);
		
		//make Game panel focusable
		setFocusable(true);
		
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

	@Override
	public void draw(Graphics2D g2d) {
		g2d.fillRect(0, 0, 200, 200);

	}

}
