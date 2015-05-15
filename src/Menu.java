import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Window;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;


public class Menu extends JFrame {
	public Menu()
	{
		//main setup
		setTitle("Amorba");
		setSize(200, 300);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container p = getContentPane();
		setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
				
		

		
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
		icon.setPreferredSize(new Dimension(iconSize, iconSize));
		icon.setMaximumSize(new Dimension(iconSize, iconSize));
		icon.setBackground(Color.BLACK);
		add(icon);
		
		//"Name" label text
		JLabel label = new JLabel("Name:");
		add(label);
		
		//Name text input field 
		JTextField field = new JTextField();
		field.setText("");
		add(field);
		field.setDocument(new JTextFieldLimit(15)); // limit input size to 15
		
		//join game button
		JButton join = new JButton("Join Game");
		join.setAlignmentX(CENTER_ALIGNMENT);
		add(join);
		
		//banner setup
		//setIconImage(img);
		
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new Menu();
	}
	
	
}
