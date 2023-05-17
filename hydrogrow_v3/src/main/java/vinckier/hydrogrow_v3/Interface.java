package vinckier.hydrogrow_v3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Interface extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello, JavaFX!");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 250, 50);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ma première fenêtre JavaFX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}