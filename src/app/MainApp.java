package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Dice with the Mice");

        showWelcomePage();
    }


    /*
    Show the welcome  page
     */
    public void showWelcomePage() {
        try {
            // Load welcome page
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/WelcomePage.fxml"));
            AnchorPane welcomePage = (AnchorPane) loader.load();

            // Show the scene containing the welcome layout
            Scene scene = new Scene(welcomePage);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Returns the main page.
    @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
