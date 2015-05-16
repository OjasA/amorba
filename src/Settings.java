import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Settings extends JFrame {
	public boolean noNames = false;
	public boolean noMasses = false;
	public boolean noColors = false;
	public boolean playPos = false;
	public boolean showFPS = false;
	public boolean status = false;
	ArrayList<Boolean> optionBox = new ArrayList<Boolean>(); // create arrayList of the above booleans
	ArrayList<JCheckBox> options = new ArrayList<JCheckBox>(); // create arraylist of checkboxes
	public Settings(String theName)
	{
		
		//main setup
		setTitle("Amorba Settings");
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		//banner setup
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("icons/amorbaicon-bmp-small.png")); // read image
																			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		setIconImage(img);
		
		//create an arrayList of booleans
		optionBox.add(noNames);
		optionBox.add(noMasses);
		optionBox.add(noColors);
		optionBox.add(playPos);
		optionBox.add(showFPS);

		//panel setup
		JPanel p = new JPanel(null);
		setContentPane(p);
		
		//contentpane setup
		JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBorder(
        BorderFactory.createEmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(5,5));
        
        //gameplay area
        JPanel gameplay = new JPanel();
        gameplay.setOpaque(true);
        gameplay.setBorder(
            BorderFactory.createTitledBorder("Gameplay"));
        
        JCheckBox names = new JCheckBox("No names");
        names.setSelected(optionBox.get(optionBox.indexOf(noNames)));
        options.add(names);
        gameplay.add(names);
        
        JCheckBox masses = new JCheckBox("No masses");
        masses.setSelected(optionBox.get(optionBox.indexOf(noMasses)));
        options.add(masses);
        gameplay.add(masses);
        
        JCheckBox colors = new JCheckBox("No colors");
        colors.setSelected(optionBox.get(optionBox.indexOf(noColors)));
        options.add(colors);
        gameplay.add(colors);
		
        //debug area
        JPanel debug = new JPanel();
        debug.setOpaque(true);
        debug.setBorder(
            BorderFactory.createTitledBorder("Debug"));

        JCheckBox pos = new JCheckBox("Show player position");
        pos.setSelected(optionBox.get(optionBox.indexOf(playPos)));
        options.add(pos);
        debug.add(pos);

        JCheckBox fps = new JCheckBox("Show FPS");
        fps.setSelected(optionBox.get(optionBox.indexOf(showFPS)));
        options.add(fps);
        debug.add(fps);
        fps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				showFPS = true;
			}
		});
        JLabel server = new JLabel("Server status: ");
        server.setFont(server.getFont().deriveFont(0, 12f));
        debug.add(server);
        
        //server status info
        if(status == false){
        	JLabel serverStatus = new JLabel("DOWN");
        	serverStatus.setFont(server.getFont().deriveFont(Font.BOLD, 12f));
        	serverStatus.setForeground(Color.red);
        	debug.add(serverStatus);
        }
        else{
        	JLabel serverStatus = new JLabel("RUNNING");
        	serverStatus.setFont(server.getFont().deriveFont(Font.BOLD, 12f));
        	serverStatus.setForeground(Color.GREEN);
        	debug.add(serverStatus);
        }
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(true);
        JButton cancel = new JButton("Cancel");
        cancel.setAlignmentX(JScrollPane.RIGHT_ALIGNMENT);
        buttonPanel.add(cancel);
        cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				noNames = noMasses = noColors = playPos = showFPS = false;
				setVisible(false);
			}
		});
        JButton apply = new JButton("Apply");
        apply.setAlignmentX(JScrollPane.RIGHT_ALIGNMENT);
        buttonPanel.add(apply);
        apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				for(int x = 0; x < options.size(); x++){
					if(options.get(x).isSelected() == true){
						options.get(x).setEnabled(false);
					}
				}
			}
		});
        JButton okay = new JButton("Accept");
        okay.setAlignmentX(JScrollPane.RIGHT_ALIGNMENT);
        buttonPanel.add(okay);
        okay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				for(int x = 0; x < options.size(); x++){
					optionBox.set(x, options.get(x).isSelected());
				}
				/* Insert code for sending data to server */
			}
		});
        
        contentPane.add(gameplay, BorderLayout.PAGE_START);
        contentPane.add(debug, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.PAGE_END);
        
        setContentPane(contentPane);
        pack();
        setVisible(true);	
	}
	
	/**
	 * Sends settings that the user has selected.
	 * @return A boolean ArrayList of user settings.
	 */
	public ArrayList<Boolean> fetchSettings(){
		return optionBox;
	}
}
