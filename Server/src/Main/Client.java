package Main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

	private String name;
	private Socket socket;
	private ObjectOutputStream objectOutputStream;

	public Client(String name){
		this.name = name;
		try {
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean send_message(Object message) {
		try {
			objectOutputStream.writeObject(message);
			objectOutputStream.flush();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}


}