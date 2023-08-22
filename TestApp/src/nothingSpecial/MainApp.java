package nothingSpecial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

  @Override
  public void start(Stage primaStage) throws Exception{
    Parent root = FXMLLoader.load(getClass().getResource("MainApp.fxml"));
    primaStage.setTitle("HydroApp");
    primaStage.setScene(new Scene(root, 1000, 600));
    primaStage.show();
  }




  // Lancer du code avant le lancement de l'application
  @Override
  public void init() throws Exception {
    System.out.println("init() called");
  }

  // Methode qui se lance a la fermeture de l'application
  @Override
  public void stop() throws Exception {
    System.out.println("stop() called");
  }

  // Lance l'application ou permet de faire du debug
  public static void main(String[] args) {
    launch(args);
  }
}
