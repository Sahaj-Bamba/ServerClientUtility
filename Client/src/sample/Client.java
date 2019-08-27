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
			System.out.println(name);
			this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			System.out.println(name);
			this.objectInputStream = new ObjectInputStream(socket.getInputStream());
			System.out.println("Input stream created");

			System.out.println("Client created.");
			System.out.println("Enter name of client.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void send_message(Object object) throws IOException {
		objectOutputStream.writeObject(object);
		objectOutputStream.flush();
	}

	public Object receive_message() throws IOException, ClassNotFoundException {
		return (Object) objectInputStream.readObject();
	}

	public String get_name() {
		return name;
	}

	public String get_group() {
		return group;
	}

	public void set_group(String group) {
		this.group = group;
	}

}