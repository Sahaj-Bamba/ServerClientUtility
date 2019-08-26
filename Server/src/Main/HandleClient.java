package Main;

import Request.GroupPass;
import Request.Response;
import Request.WhoIAm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import static Main.Main.GAMER;

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

		boolean flag;

		try {

			WhoIAm ob1 = (WhoIAm) objectInputStream.readObject();
			GAMER.add_client("extra", ob1.getName());
			System.out.println("Client Got and name set");

			do {
				GroupPass ob2 = (GroupPass) objectInputStream.readObject();
				if(GAMER.add_group(ob2.get_group_name(),ob2.get_password())){
					GAMER.send_message(new Response(0,""),);
					flag = false;
					GAMER.remove_client("extra",ob2.get_client_name());
					GAMER.add_client(ob2.get_group_name(),ob2.get_client_name());
					System.out.println("Client successfully added to the specified group");
				}
				else{
					flag = true;
					GAMER.send_message(new Response(1,"Group already exist please try a new name."));
					System.out.println("There was a problem retrying");
				}
			}while(flag);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


		while (true) {
			try {
				Object message = (Object) objectInputStream.readObject();
				System.out.println("Message received");

//				if ()

				/*  Do Rest of processing on the object here    */

			} catch (Exception e) {
				System.out.println("Client Disconnected");
				e.printStackTrace();
			}
		}
	}


}
