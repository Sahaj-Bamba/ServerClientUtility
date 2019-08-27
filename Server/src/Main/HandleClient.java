package Main;

import Constant.Request;
import Request.GroupPass;
import Request.Response;
import Request.WhoIAm;
import Request.GroupList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static Main.Main.GAMER;

public class HandleClient implements Runnable{

	private Socket socket;
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;

	public HandleClient(Socket socket) {
		this.socket = socket;
		try {
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
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
			GAMER.add_client("extra", ob1.getName(),objectOutputStream);
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


				/*      If Else for server handelling           */

				String req = (String) message.toString();

				if (req.equals(Request.GROUPPASS)  ){

					System.out.println("Group creation request");

					do {
						GroupPass ob2 = (GroupPass) message;
						if(GAMER.add_group(ob2.get_group_name(),ob2.get_password())){
							GAMER.send_message(new Response(0,""),ob2.get_group_name(),ob2.get_client_name());
							flag = false;
							GAMER.remove_client("extra",ob2.get_client_name());
							GAMER.add_client(ob2.get_group_name(),ob2.get_client_name(),objectOutputStream);
							System.out.println("Client successfully added to the specified group");
						}
						else{
							flag = true;
							GAMER.send_message(new Response(1,"Group already exist please try a new name."),ob2.get_group_name(),ob2.get_client_name());
							System.out.println("There was a problem retrying");
						}
					}while(flag);

				}else if (req.equals(Request.GROUPLIST)){

					System.out.println("Group list Request");

					GroupList ob3 = (GroupList)(message);
					GAMER.send_message((Object)GAMER.get_group_list(),ob3.getter());

				}










				/*  Do Rest of processing on the object here    */

			} catch (Exception e) {
				System.out.println("Client Disconnected");
				e.printStackTrace();
			}
		}
	}


}
