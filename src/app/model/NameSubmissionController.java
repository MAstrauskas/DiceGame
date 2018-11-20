package app.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import app.domain.Player;

public class NameSubmissionController {
    public Player player1;
    public Player player2;

    @FXML
    private TextField playerName1;

    @FXML
    private TextField playerName2;


    @FXML
    private Button btnSubmit;

    @FXML
    void onSubmitClicked(ActionEvent event) {
        player1 = new Player(playerName1.getText());
        String pName1 = playerName1.getText();

        player2 = new Player(playerName2.getText());
        String pName2 = playerName2.getText();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Sign up Successful!");
        alert.showAndWait();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/DicePage.fxml"));

        try {
            Parent root = (Parent) loader.load();
            DicePageController sc = loader.getController();
            sc.setText(pName1);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
