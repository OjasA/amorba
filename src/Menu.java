import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Menu extends JFrame{
	public Menu()
	{
		//main setup
		setTitle("Amorba");
		setSize(200, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//panel setup
		JPanel p = new JPanel(null);
		
		//join game button
		JButton join = new JButton("Join Game");
		join.setBounds(50, 220, 100, 30);
		p.add(join);
		setContentPane(p);
		
		//amorba icon
		JLabel icon = new JLabel();
		BufferedImage img = null;
		int iconSize = 100;
		try {
			img = ImageIO.read(new File("icons/amorbaicon-bmp.png")); //read image
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Image img2 = img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH); //resize image to fit swing element
		icon.setIcon(new ImageIcon(img2));
		icon.setBounds(100 - iconSize / 2, 0, iconSize, iconSize);
		p.add(icon);
		setContentPane(p);
		
		//"Name" label text
		JTextArea label = new JTextArea("Name:");
		label.setEditable(false);
		label.setBounds(80, 130, 50, 20);
		label.setBackground(p.getBackground());
		p.add(label);
		setContentPane(p);
		
		//Name text input field 
		JTextField field = new JTextField();
		field.setText("");
		field.setBounds(50, 150, 100, 25);
		p.add(field);
		field.setDocument(new JTextFieldLimit(15)); // Limit input size to 15
		setContentPane(p);
		
	}
	
	public static void main(String[] args)
	{
		new Menu();
	}
	
	
	
}
