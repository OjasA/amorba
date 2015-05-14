import javax.swing.JFrame;

public class Window extends JFrame {

	private Window() {
		this.setTitle("Game");
		this.setSize(600, 800);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// this.setContentPane(new Game()); //main game class
	}

	public static void main(String[] args) {
		new Window();
	}

}
