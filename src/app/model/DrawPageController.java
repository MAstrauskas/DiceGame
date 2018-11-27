package app.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DrawPageController implements Initializable {
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
