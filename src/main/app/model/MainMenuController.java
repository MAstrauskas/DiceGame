package main.app.model;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Pane rootPane;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnInstruction;

    @FXML
    private Button btnExit;
    
    /*
     * Loads Name Submission Page when Start button is pressed
     */
    @FXML
    private void onStartClicked(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/main/app/view/NameSubmissionPage.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
    /*
     * Loads Instruction Page when Instruction button is pressed
     */
    @FXML
    private void onInstructionClicked(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/main/app/view/InstructionPage.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
    /*
     * Exits the game when Exit button is pressed
     */
    @FXML
    private void onExitClicked(ActionEvent event) {
        Platform.exit();
    }
}
