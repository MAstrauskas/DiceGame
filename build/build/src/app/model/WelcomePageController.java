package app.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class WelcomePageController {

    @FXML
    private Pane rootPane;

    @FXML
    public Button btnSubmit;

    @FXML
    void onSubmitClicked(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/app/view/MainMenuPage.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}

