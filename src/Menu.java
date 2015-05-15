import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Window;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Menu extends JFrame {
	public Menu()
	{
		//main setup
		setTitle("Amorba");
		setSize(205, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		
		
		//panel setup
		JPanel p = new JPanel(null);
		setContentPane(p);
		
		
		//join game button
		JButton join = new JButton("Join Game");
		join.setBounds(50, 235, 100, 30);
		p.add(join);
		
		//amorba icon
		JLabel icon = new JLabel();
		BufferedImage img = null;
		int iconSize = 100;
		try {
			img = ImageIO.read(new File("icons/amorbaicon-bmp.png")); // read image
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Image img2 = img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH); // resize image to fit swing element
		icon.setIcon(new ImageIcon(img2));
		icon.setBounds(100 - iconSize / 2, 0, iconSize, iconSize);
		p.add(icon);
		
		//"Name" label text
		JLabel label = new JLabel("Name:");
		label.setBounds(80, 130, 50, 20);
		label.setBackground(p.getBackground());
		p.add(label);
		
		//Name text input field 
		JTextField field = new JTextField();
		field.setText("");
		field.setBounds(30, 150, 140, 25);
		p.add(field);
		field.setDocument(new JTextFieldLimit(15)); // limit input size to 15
		
		//banner setup
		try {
			img = ImageIO.read(new File("icons/amorbaicon-bmp-small.png")); // read image
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		setIconImage(img);
		
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new Menu();
	}
	
	
}
