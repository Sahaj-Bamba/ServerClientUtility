package sample;

import Windows.ConfirmBox;
import javafx.application.Application;
import javafx.stage.Stage;
import Windows.AlertBox;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Title of the Window");
        primaryStage.show();
//        AlertBox alertBox = new AlertBox("my first","Slay them all");
//        alertBox.start();
//
        ConfirmBox confrim= new ConfirmBox("ada","dss");
        confrim.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}