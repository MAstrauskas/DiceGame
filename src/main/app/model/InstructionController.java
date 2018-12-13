package main.app.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class InstructionController {

    @FXML
    private Pane rootPane;
    
    /*
     * Loads Main Menu page when the button is pressed
     */
    @FXML
    public void onSubmitClicked(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/main/app/view/MainMenuPage.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}

