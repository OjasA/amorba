import java.awt.Color;

import javax.swing.JFrame;

public class Window extends JFrame {

<<<<<<< HEAD
public class Window extends JFrame{

	private Window()
	{
		this.setTitle("Amorba");
		this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setContentPane(new Menu()); //main game class
        
        
=======
	private Window() {
		this.setTitle("Game");
		this.setSize(600, 800);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// this.setContentPane(new Game()); //main game class
>>>>>>> origin/master
	}

	public static void main(String[] args) {
		new Window();
	}

}
