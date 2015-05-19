import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConnectionManager extends JFrame {
	private String hostname;
	private int port;
	Socket socketClient;

	public ConnectionManager(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}

	/**
	 * Attempts to establish connection with a host.
	 * 
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void connect() throws UnknownHostException, IOException {
		socketClient = new Socket(hostname, port);
	}

	/**
	 * Reads data from the host.
	 * 
	 * @throws IOException
	 */
	public void readResponse() throws IOException {
		/* INSERT RESPONSE FROM SERVER */
	}

	public static void main(String arg[]) {
		// Creating a client object
		ConnectionManager client = new ConnectionManager("localhost", 9990);
		try {
			// trying to establish connection to the server
			client.connect();
			// if successful, read response from server
			client.readResponse();

		} catch (UnknownHostException e) {
			JFrame err = new JFrame();
			JOptionPane.showMessageDialog(err,
					"Host unknown. Cannot establish connection",
					"Connection error", JOptionPane.QUESTION_MESSAGE);
		} catch (IOException e) {
			JFrame err = new JFrame();
			JOptionPane
					.showMessageDialog(
							err,
							"<html>Cannot establish connection; the server may not be up at this time.<br>The following was received from the server:<br><br>"
									+ e.getMessage(), "Connection error",
							JOptionPane.WARNING_MESSAGE);
		}
	}
}
