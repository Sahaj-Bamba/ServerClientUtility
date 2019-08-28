package Windows;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

    private String title;
    private String message;
    private Scene scene;
    private Label label;

    public AlertBox(String title, String message) {
        this.title = title;
        this.message = message;
        this.label = new Label();
    }

    public void changeText(String text){
        label.setText(text);
    }

    public void start() {

        Stage window = new Stage();

        //Block events to other windows

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        label.setText(message);

        Button closeButton = new Button("Close this window");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning

        this.scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}