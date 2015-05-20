import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.RenderingHints;
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
		// set up key binding input and action maps
		int mapName = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = this.getInputMap(mapName);
		ActionMap amap = this.getActionMap();

		// map keys
		// setup escape to close window
		KeyStroke esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
		imap.put(esc, "closeWindow");
		amap.put("closeWindow", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				window.closeWindow();
			}
		});

		// setup F5 to attempt to manually refresh the connection
		KeyStroke f5 = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0);
		imap.put(f5, "refreshConnection");
		amap.put("refreshConnection", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConnectionManager.main(null);
			}
		});
		
		// black mode
		KeyStroke black = KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK);
		imap.put(black, "toBlack");
		amap.put("toBlack", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				window.toBlack();
			}
		});
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
	public void draw(final Graphics2D g2d) {
		Rectangle r = this.getBounds();
		final Ellipsoid p = new Ellipsoid(this);
		g2d.fillRect(0, 0, r.width, r.height); // draw dimensions according to frame size
		p.draw(g2d);
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Point point = MouseInfo.getPointerInfo().getLocation();
				p.move(g2d,point);
				System.out.println("(" + point.getX() + "," + point.getY() + ")");
			}
		});
	}

}
