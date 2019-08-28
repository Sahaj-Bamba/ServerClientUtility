package sample;

import Windows.ConfirmBox;
import Windows.ListBox;
import javafx.application.Application;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import Windows.AlertBox;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Title of the Window");
        primaryStage.show();
//        AlertBox alertBox = new AlertBox("my first","Slay them all");
//        alertBox.start();
//
        ArrayList<String> res;
        ArrayList<String> ques = new ArrayList<String>();
        ques.add("Jack");
        ques.add("Jimmy");
        ques.add("John");
        ListBox listBox = new ListBox("hi","killers",ques);
        res = listBox.start(SelectionMode.SINGLE);
        System.out.println(res);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
