
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
 
public class DatabaseManager {
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
            System.err.println("Host unknown. Cannot establish connection");
        } catch (IOException e) {
            System.err.println("Cannot establish connection. Server may not be up."+e.getMessage());
        }
	}
}
