package main.app.model;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

public class WelcomePageController {

    @FXML
    private Pane rootPane;

    @FXML
    public Button btnSubmit;
    
    /*
     * Loads Main Menu when Begin button is pressed
     */
    @FXML
    void onSubmitClicked(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/main/app/view/MainMenuPage.fxml"));
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), pane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1);
        fadeIn.play();
        rootPane.getChildren().setAll(pane);
    }
}

