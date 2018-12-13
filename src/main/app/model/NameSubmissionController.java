package main.app.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

import main.app.domain.Player;

public class NameSubmissionController {
    public Player player1;
    public Player player2;

    @FXML
    private Pane rootPane;

    @FXML
    public TextField playerName1;

    @FXML
    public TextField playerName2;

    /*
     * Starts the game if there are no errors in Player Names
     */
    @FXML
    public void onSubmitClicked(ActionEvent event) throws IOException {
        // If a name is blank or contains anything, but letters, show an error
        if ((playerName1.getText().isEmpty() || playerName2.getText().isEmpty())
                || (!playerName1.getText().matches("[a-zA-Z]+") || !playerName2.getText().matches("[a-zA-Z]+"))) {
            showErrorAlert();
        } else if (playerName1.getText().equals(playerName2.getText())) {
        	showSameNameError();
        } else {
            player1 = new Player(playerName1.getText());
            player2 = new Player(playerName2.getText());

            String pName1 = playerName1.getText();
            String pName2 = playerName2.getText();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/app/view/DicePage.fxml"));
            changeSceneAndSetPlayerNames(pName1, pName2, loader, rootPane);
        }
    }
    
    /*
     * Loads Rule Page when Rules button is pressed
     */
    @FXML
    private void onRulesClicked(ActionEvent event) throws IOException {
    	Pane pane = FXMLLoader.load(getClass().getResource("/main/app/view/RulesPage.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    /*
     * Loads Main Menu when Back button is pressed
     */
    @FXML
    private void onBackClicked(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/main/app/view/MainMenuPage.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    /*
     * Sets Player Names for the game and changes scene to the Game scene
     */
    public static void changeSceneAndSetPlayerNames(String pName1, String pName2, FXMLLoader loader, Pane rootPane) {
        try {
            Pane pane = loader.load();
            DicePageController sc = loader.getController();
            sc.setPlayerOneText(pName1);
            sc.setPlayerTwoText(pName2);
            rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * If one of the names has errors, shows this error
     */
    private void showErrorAlert() {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Name error");
        errorAlert.setHeaderText("Name required.");
        errorAlert.setContentText("Name cannot be empty or include numbers.\nIt must contain letters.\nPlease enter a valid name.");

        errorAlert.showAndWait();
    }
    
    /*
     * If players have the same names, shows an error
     */
    private void showSameNameError() {
    	Alert sameNameAlert = new Alert(Alert.AlertType.ERROR);
    	sameNameAlert.setTitle("Same Name error");
    	sameNameAlert.setHeaderText("Names cannot be the same");
    	sameNameAlert.setContentText("We recommend adding a word or a letter to your name if you have same names");
    	
    	sameNameAlert.showAndWait();
    }
}
