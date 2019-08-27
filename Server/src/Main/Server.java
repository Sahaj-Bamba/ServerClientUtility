package Main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {

	private ServerSocket serverSocket;
	private Socket socket;
	private HashMap<String,Group> group;

	public void start(){

		boolean flag;
		int port = 5555;
		do {
			try {
				serverSocket = new ServerSocket(port);
				flag = true;
			} catch (IOException e) {
				flag = false;
				port++;
			}
		}while(flag);

		System.out.println("Server started");
		run();

	}

	protected void run() {

		while (true) {
			try {
				socket = serverSocket.accept();
				System.out.println("Client socket accepted");
				Thread t = new Thread(new HandleClient(socket));
				System.out.println("Handle client created");
				t.start();
				System.out.println("Thread Started");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}