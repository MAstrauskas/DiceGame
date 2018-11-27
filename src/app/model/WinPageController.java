package app.model;

import app.domain.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WinPageController implements Initializable {
    public String playerOne;
    public String playerTwo;

    @FXML
    private FlowPane rootPane;

    @FXML
    private Label winner;

    /*
     * Play Again button is clicked and user is redirected to NameSubmissionPage
     */
    @FXML
    private void onPlayAgainClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/DicePage.fxml"));
        NameSubmissionController.changeSceneAndSetPlayerNames(playerOne, playerTwo, loader, rootPane);
    }

    /*
     * Main Menu button is clicked and user is redirected to MainMenuPage
     */
    @FXML
    void onMainMenuClicked(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/app/view/MainMenuPage.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    /*
     * Set the name of a winner
     */
    public void setWinnerName(String name) {
        winner.setText("Congratulations \n" + name + ",\n you have won!");
    }

    /*
     * Sets both player names for a new game to the ones from a previous game
     */
    public void setPlayerNames(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
