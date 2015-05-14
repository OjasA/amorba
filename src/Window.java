import javax.swing.JFrame;


public class Window extends JFrame{

	private Window()
	{
		this.setTitle("Game");
		this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setContentPane(new Game()); //main game class
        
        
	}
	
	public static void main(String[] args) {
		new Window();

	}

}
