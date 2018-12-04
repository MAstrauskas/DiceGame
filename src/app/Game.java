package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Game extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/app/view/WelcomePage.fxml"));
        primaryStage.setTitle("DiceMania");
        Scene scene = new Scene(root);
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Righteous");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(Game.class.getResourceAsStream("/diceIconRed.png")));
        primaryStage.sizeToScene();
        primaryStage.show();
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
        primaryStage.setMaxWidth(primaryStage.getWidth());
        primaryStage.setMaxHeight(primaryStage.getHeight());
    }

    public static void main(String... args) {
        launch(args);
    }
}