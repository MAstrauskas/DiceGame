package app.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class DrawPageController {
    public String playerOne;
    public String playerTwo;

    @FXML
    private FlowPane rootPane;

    @FXML
    private void onPlayAgainClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/DicePage.fxml"));
        NameSubmissionController.changeSceneAndSetPlayerNames(playerOne, playerTwo, loader, rootPane);
    }

    @FXML
    void onMainMenuClicked(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/app/view/MainMenuPage.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void setPlayerNames(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }
}
