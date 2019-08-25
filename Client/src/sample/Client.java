package sample;

import java.io.*;
import java.net.Socket;

public class Client {

	private Socket socket;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;
	private String name;
	private String group;

	public Client(String ip, int port, String name) {
		try {
			this.name = name;
			this.socket = new Socket(ip, port);
			this.objectInputStream = new ObjectInputStream(socket.getInputStream());
			this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

			System.out.println("Client created.");
			System.out.println("Enter name of client.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(Object object) throws IOException {
		objectOutputStream.writeObject(object);
		objectOutputStream.flush();
	}

	public String getName() {
		return name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}