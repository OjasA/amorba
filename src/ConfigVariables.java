import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class ConfigVariables {

	private String configLocation = System.getProperty("user.home")
			+ "\\.amorba\\";
	HashMap<String, String> configs = new HashMap<String, String>();
	public static boolean keyboard = false;
	
	/**
	 * Color of the background for the client.
	 */
	public static Color backgroundColor = Color.gray;
	
	/**
	 * The name of the player
	 */
	public static String playerName = "Amorba";
	
	/**
	 * Color of the player
	 */
	public static Color playerColor = Color.blue;
	
	/**
	 * Scale of the map in accordance with the size of the player
	 */
	public static double mapScale = 1.0;
	
	/**
	 * Default particle size
	 */
	public static int size = 20; 

	public void writeConfig() {

	}

	private void readConfig() {

	}
}