import java.awt.Color;
import javax.swing.JFrame;

public class Window extends JFrame{
	
	private Window(){
		
		this.setTitle("Amorba");
		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setContentPane(new Menu()); //main game class
	}

	public static void main(String[] args) {
		new Window();
	}

}
