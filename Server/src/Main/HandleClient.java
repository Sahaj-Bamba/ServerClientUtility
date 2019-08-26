package Main;

import Request.WhoIAm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class HandleClient implements Runnable{

	private Socket socket;
	private ObjectInputStream objectInputStream;

	public HandleClient(Socket socket) {
		this.socket = socket;
		try {
			objectInputStream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * When an object implementing interface <code>Runnable</code> is used
	 * to create a thread, starting the thread causes the object's
	 * <code>run</code> method to be called in that separately executing
	 * thread.
	 * <p>
	 * The general contract of the method <code>run</code> is that it may
	 * take any action whatsoever.
	 *
	 * @see Thread#run()
	 */

	@Override
	public void run() {

		try {
			WhoIAm ob = (WhoIAm) objectInputStream.readObject();
			System.out.println("Client Got and name set");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


		while (true) {
			try {
				Object message = (Object) objectInputStream.readObject();
				System.out.println("Message received");

				if ()

				/*  Do Rest of processing on the object here    */

			} catch (Exception e) {
				System.out.println("Client Disconnected");
				e.printStackTrace();
			}
		}
	}


}
