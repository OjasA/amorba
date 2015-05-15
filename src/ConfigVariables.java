import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class ConfigVariables {

	private String configLocation = System.getProperty("user.home")
			+ "\\.amorba\\";
	HashMap<String, String> configs = new HashMap<String, String>();
	public static boolean keyboard = false;
	public static Color backgroundColor = Color.gray;
	public static String playerName = "Amorba";
	public static Color playerColor = Color.blue;
	public static double mapScale = 1.0; // scales map according to player size
	public static int size = 20; // default size of particles

	public void writeConfig() {

	}

	private void readConfig() {

	}
}