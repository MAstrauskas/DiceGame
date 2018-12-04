package app.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class WinPageController {
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
    public void onPlayAgainClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/DicePage.fxml"));
        NameSubmissionController.changeSceneAndSetPlayerNames(playerOne, playerTwo, loader, rootPane);
    }

    /*
     * Main Menu button is clicked and user is redirected to MainMenuPage
     */
    @FXML
    public void onMainMenuClicked(ActionEvent event) throws IOException {
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
}
