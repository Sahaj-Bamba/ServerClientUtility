package Windows;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListBox
{
    private Stage window;
    ListView<String> listView;
    Scene scene ;
    Button button;

    public void start()
    {
        window = new Stage();
        window.setTitle("Title of the Window");

        //ListView

        button = new Button("Submit");

        listView = new javafx.scene.control.ListView<>();
        listView.getItems().addAll("Iron Man", "Titanic", "Baby", "Uri ");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        button.setOnAction(e -> buttonClicked());
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(listView,button);


        scene = new Scene(layout, 600, 550);
        window.setScene(scene);
        window.show();
    }

    private void buttonClicked() {


    /*private void getChoice(ChoiceBox<String> choiceBox) {

        String food = choiceBox.getValue();

        System.out.println(food);
    }*/
        String message = "";
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();

        for (String m : movies) {
            message += m + "\n";
        }
        System.out.println(message);
    }


}
