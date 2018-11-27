package app;

import app.model.WelcomePageController;
import app.model.WinPageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/app/view/WelcomePage.fxml"));
        primaryStage.setTitle("Dice with the Mice");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String... args) {
        launch(args);
    }
}