package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.Main;

import java.io.IOException;

public class Controller1 {

	public void submit(){
		System.out.println("1");

		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("../FXML/scene2.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Main.PRIMARYSTAGE.setScene(new Scene(root,Main.WIDTH,Main.HEIGHT));

	}

}
