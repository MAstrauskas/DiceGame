package app.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

import app.domain.Player;

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
     * Starts the game
     */
    @FXML
    public void onSubmitClicked(ActionEvent event) {
        // If a name is blank or contains anything, but letters, show an error
        if ((playerName1.getText().isEmpty() || playerName2.getText().isEmpty())
                || (!playerName1.getText().matches("[a-zA-Z]+") || !playerName2.getText().matches("[a-zA-Z]+"))) {
            showErrorAlert();
        } else {
            player1 = new Player(playerName1.getText());
            player2 = new Player(playerName2.getText());

            String pName1 = playerName1.getText();
            String pName2 = playerName2.getText();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/DicePage.fxml"));
            changeSceneAndSetPlayerNames(pName1, pName2, loader, rootPane);
        }
    }

    /*
     * Goes back to the Main Menu
     */
    @FXML
    private void onBackClicked(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/app/view/MainMenuPage.fxml"));
        rootPane.getChildren().setAll(pane);
    }


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

    private void showErrorAlert() {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Name error");
        errorAlert.setHeaderText("Name required.");
        errorAlert.setContentText("Name cannot be blank and must contain letters. Please enter a valid name.");

        errorAlert.showAndWait();
    }
}
