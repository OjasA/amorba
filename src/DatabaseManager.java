
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class DatabaseManager extends JFrame {
	private String hostname;
	private int port;
	Socket socketClient;
	
	public DatabaseManager(String hostname, int port){
		this.hostname = hostname;
		this.port = port;
	}
	
	public void connect() throws UnknownHostException, IOException {
		socketClient = new Socket(hostname,port);
	}
	
	public void readResponse() throws IOException{
		/* INSERT RESPONSE FROM SERVER */
    }
	
	public static void main(String arg[]){
        //Creating a SocketClient object
        DatabaseManager client = new DatabaseManager ("localhost",9990);
        try {
            //trying to establish connection to the server
            client.connect();
            //if successful, read response from server
            client.readResponse();

        } catch (UnknownHostException e) {
        	JFrame err = new JFrame();
        	JPanel p = new JPanel();
        	err.setTitle("Error!");
    		err.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		JLabel server = new JLabel("Host unknown. Cannot establish connection");
            p.add(server);
            err.add(p);
    		err.setVisible(true);
        } catch (IOException e) {
        	JFrame err = new JFrame();
        	JPanel p = new JPanel();
        	err.setTitle("Error!");
    		err.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		JLabel server = new JLabel("Cannot establish connection. Server may not be up."+e.getMessage());
            p.add(server);
            err.add(p);
    		err.setVisible(true);
        }
	}
}
