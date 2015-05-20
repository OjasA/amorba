import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

public class KeyBinding extends AbstractAction implements ActionListener {
	private GameWindow window;
	public KeyBinding(GameWindow w){
		window = w;
	}
	public void actionPerformed(ActionEvent e) {
			window.closeWindow();
		}
	}
