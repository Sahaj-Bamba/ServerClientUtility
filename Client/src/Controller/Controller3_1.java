package Controller;

import Request.GroupPass;

import java.awt.*;
import java.io.IOException;

import static sample.Main.GAMER;

public class Controller3_1 {

	private TextField name;
	private TextField password;

	public void submit(){
		System.out.println("3_1 Hi");

		try {
			GAMER.send_message(new GroupPass(password.getText(),name.getText(),GAMER.get_name()));
			System.out.println("Group Data Sent");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
