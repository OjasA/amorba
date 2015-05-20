import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameWindow extends JFrame {
	private String name;

	public GameWindow(String theName) {

		// string parsing
		if (theName.matches(" *")) {
			name = "Amoeba";
		} else {
			name = theName;
		}

		// main setup
		setTitle("Amorba");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);

		// banner setup
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("icons/amorbaicon-bmp-small.png")); // read
																			// image

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		setIconImage(img);

		// go back to menu when closing
		addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				if (name == "Amoeba")
					name = "";
				new Menu(name);
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
			}
		});

		setContentPane(new Game(name, this));

	}

	public void closeWindow() {
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}