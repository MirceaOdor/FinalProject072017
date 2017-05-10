package GUILayer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Menu extends Application implements EventHandler<ActionEvent> {

    Button button;

    public static void main(String[] args) {
      launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Main ");
        button = new Button();
        button.setText("Manager");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300,250);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    @Override
    public void handle(ActionEvent event) {

    }
}

