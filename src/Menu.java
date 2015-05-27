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

public class Menu extends JFrame {
	public Menu(String name) {
		// main setup
		setTitle("Amorba");
		setSize(205, 335);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);

		// panel setup
		JPanel p = new JPanel(null);
		setContentPane(p);

		// amorba icon
		JLabel icon = new JLabel();
		BufferedImage img = null;
		Image img2 = null;
		int iconSize = 100;
		try {
			img = ImageIO.read(new File("resources/amorbaicon-bmp.png")); // read
																		// image
			img2 = img.getScaledInstance(iconSize, iconSize,
					Image.SCALE_SMOOTH); // resize image to fit swing element
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		icon.setIcon(new ImageIcon(img2));
		icon.setBounds(100 - iconSize / 2, 0, iconSize, iconSize);
		p.add(icon);

		// "Name" label text
		JLabel label = new JLabel("Name:");
		label.setBounds(80, 130, 50, 20);
		label.setBackground(p.getBackground());
		p.add(label);

		// Name text input field
		final JTextField field = new JTextField();
		field.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					setVisible(false);
					new GameWindow(field.getText());
				}
			}
		});
		field.setBounds(30, 150, 140, 25);
		p.add(field);
		field.setDocument(new JTextFieldLimit(15)); // limit input size to 15

		// join game button
		JButton join = new JButton("Join Game");
		join.setBounds(50, 235, 100, 30);
		join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new GameWindow(field.getText());
			}
		});
		p.add(join);

		// settings button
		JButton settings = new JButton("Settings");
		settings.setBounds(50, 270, 100, 30);
		settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Settings(field.getText());
			}
		});
		p.add(settings);

		// banner setup
		try {
			img = ImageIO.read(new File("resources/amorbaicon-bmp-small.png")); // read
																			// image
			setIconImage(img);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		

		// fill field w/ previous name
		field.setText(name);

		// set visible
		setVisible(true);
	}

	public static void main(String[] args) {
		new Menu("");
	}

}
