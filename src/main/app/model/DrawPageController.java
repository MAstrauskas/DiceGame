package main.app.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class DrawPageController {
    public String playerOne;
    public String playerTwo;

    @FXML
    private FlowPane rootPane;
    
    @FXML
    private Label playerOneScore;

    @FXML
    private Label playerOneNameScore;
    
    @FXML
    private Label playerTwoScore;
    
    @FXML
    private Label playerTwoNameScore;
    
    /*
     * Loads Dice Page when Play Again button is clicked
     */
    @FXML
    private void onPlayAgainClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/app/view/DicePage.fxml"));
        NameSubmissionController.changeSceneAndSetPlayerNames(playerOne, playerTwo, loader, rootPane);
    }
    
    /*
     * Loads Main Menu when Main Menu button is clicked
     */
    @FXML
    void onMainMenuClicked(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/main/app/view/MainMenuPage.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
    /*
     * Sets the names of the Players for the next game and this page scores
     */
    public void setPlayerNames(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.playerOneNameScore.setText(playerOne + " score:");
        this.playerTwoNameScore.setText(playerTwo + " score:");
    }
    
    /*
     * Sets the scores for the players in this page
     */
    public void setPlayerScores(int playerOneScore, int playerTwoScore) {
    	this.playerOneScore.setText(Integer.toString(playerOneScore));
    	this.playerTwoScore.setText(Integer.toString(playerTwoScore));
    }
}
