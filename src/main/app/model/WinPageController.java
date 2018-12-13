package main.app.model;

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
    
    @FXML
    private Label winnerScore;

    @FXML
    private Label winnerNameScore;
    
    @FXML
    private Label looserScore;
    
    @FXML
    private Label looserNameScore;
    
    /*
     * Play Again button is clicked and user is redirected to NameSubmissionPage
     */
    @FXML
    public void onPlayAgainClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/app/view/DicePage.fxml"));
        NameSubmissionController.changeSceneAndSetPlayerNames(playerOne, playerTwo, loader, rootPane);
    }

    /*
     * Main Menu button is clicked and user is redirected to MainMenuPage
     */
    @FXML
    public void onMainMenuClicked(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/main/app/view/MainMenuPage.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    /*
     * Sets the name of a winner
     */
    public void setWinnerName(String name) {
        winner.setText("Congratulations \n" + name + ",\n you have won!");
    }

    /*
     * Sets both Player Names for a new game to the ones from a previous game
     */
    public void setPlayerNames(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.winnerNameScore.setText(playerOne + " score:");
        this.looserNameScore.setText(playerTwo + " score:");
    }
    
    /*
     * Sets the scores for the players in this page
     */
    public void setPlayerScores(int winnerScore, int looserScore) {
    	this.winnerScore.setText(Integer.toString(winnerScore));
    	this.looserScore.setText(Integer.toString(looserScore));
    }
}
