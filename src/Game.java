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

public class Game extends AbstractDraw {
	private String name;
	private GameWindow window;

	public Game(String theName, GameWindow theWindow) {
		// get window this frame is being hosted in
		window = theWindow;

		// start game thread
		Thread gameThread = new Thread() {
			@Override
			public void run() {
				act();
			}
		};

		// key binding stuff
		int mapName = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = this.getInputMap(mapName);

		KeyStroke esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
		// KeyStroke a = KeyStroke.getKeyStroke('a');
		KeyBinding bind = new KeyBinding(window);

		imap.put(esc, "close");
		ActionMap amap = this.getActionMap();
		amap.put("close", bind);
		
		this.requestFocus();
	}

	// main game tick
	public void act() {
		try {
			Thread.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.fillRect(0, 0, 200, 200);

	}

}
