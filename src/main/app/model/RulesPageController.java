package main.app.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class RulesPageController {

    @FXML
    private Pane rootPane;
    
    /*
     * Loads Name Submission Page when Go Back button is pressed
     */
    @FXML
    public void onRulesClicked(ActionEvent event) throws IOException {
    	Pane pane = FXMLLoader.load(getClass().getResource("/main/app/view/NameSubmissionPage.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}

